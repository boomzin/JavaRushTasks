package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParserV1 implements IPQuery{

    private final List<String> allLogs = new ArrayList<>();

    Map<Long, HashSet<String>> dateIPMap = new HashMap<>();
    Map<String, HashMap<Long, HashSet<String>>> userDateIPMap = new HashMap<>();
    EnumMap<Event, HashMap<Long, HashSet<String>>> eventDateIPMap = new EnumMap<>(Event.class);
    EnumMap<Status, HashMap<Long, HashSet<String>>> statusDateIPMap = new EnumMap<>(Status.class);


    public LogParserV1(Path logDir) {
        ParserFileVisitor parserFileVisitor = new ParserFileVisitor();
        try {
            Files.walkFileTree(logDir, parserFileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fillFields();
    }

    public void fillFields() {
        for (String logLine : allLogs) {
            Pattern ipPattern = Pattern.compile("([0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3})");
            Pattern datePattern = Pattern.compile("([0-9]{1,2}[.][0-9]{1,2}[.][0-9]{2,4}[\\s][0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2})");
            Pattern statusPattern = Pattern.compile("(?<=\\s)\\w+\\z");

            Matcher ipMatcher = ipPattern.matcher(logLine);
            Matcher dateMatcher = datePattern.matcher(logLine);
            Matcher statusMatcher = statusPattern.matcher(logLine);
            ipMatcher.find();
            dateMatcher.find();
            statusMatcher.find();
            String ip = ipMatcher.group();
            String user = logLine.substring(ipMatcher.end() + 1, dateMatcher.start() - 1);
            String eventString = logLine.substring(dateMatcher.end() +1, statusMatcher.start() - 1);
            if (eventString.contains("TASK")) {
                eventString = (eventString.substring(0, eventString.lastIndexOf(" ")));
            }
            Event event = Event.valueOf(eventString);

            Status status = Status.valueOf(statusMatcher.group());
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            Long foundDate = null;
            try {
                foundDate = format.parse(dateMatcher.group()).getTime();
            } catch (ParseException e) {
                System.out.println("Date parse error");
            }

            if (dateIPMap.containsKey(foundDate)) {
                HashSet<String> ips = dateIPMap.get(foundDate);
                ips.add(ip);
            } else {
                HashSet<String> ips = new HashSet<>();
                ips.add(ip);
                dateIPMap.put(foundDate, ips);
            }

            if (userDateIPMap.get(user) == null) {
                HashSet<String> ips = new HashSet<>();
                ips.add(ip);
                HashMap<Long, HashSet<String>> dateIps = new HashMap<>();
                dateIps.put(foundDate, ips);
                userDateIPMap.put(user, dateIps);
            } else {
                if (userDateIPMap.get(user).containsKey(foundDate)) {
                    HashSet<String> ips = userDateIPMap.get(user).get(foundDate);
                    ips.add(ip);
                } else {
                    HashSet<String> ips = new HashSet<>();
                    ips.add(ip);
                    HashMap<Long, HashSet<String>> dateIps = userDateIPMap.get(user);
                    dateIps.put(foundDate, ips);
                }
            }
            if (eventDateIPMap.get(event) == null) {
                HashSet<String> ips = new HashSet<>();
                ips.add(ip);
                HashMap<Long, HashSet<String>> dateIps = new HashMap<>();
                dateIps.put(foundDate, ips);
                eventDateIPMap.put(event, dateIps);
            } else {
                if (eventDateIPMap.get(event).containsKey(foundDate)) {
                    HashSet<String> ips = eventDateIPMap.get(event).get(foundDate);
                    ips.add(ip);
                } else {
                    HashSet<String> ips = new HashSet<>();
                    ips.add(ip);
                    HashMap<Long, HashSet<String>> dateIps = eventDateIPMap.get(event);
                    dateIps.put(foundDate, ips);
                }
            }
            if (statusDateIPMap.get(status) == null) {
                HashSet<String> ips = new HashSet<>();
                ips.add(ip);
                HashMap<Long, HashSet<String>> dateIps = new HashMap<>();
                dateIps.put(foundDate, ips);
                statusDateIPMap.put(status, dateIps);
            } else {
                if (statusDateIPMap.get(status).containsKey(foundDate)) {
                    HashSet<String> ips = statusDateIPMap.get(status).get(foundDate);
                    ips.add(ip);
                } else {
                    HashSet<String> ips = new HashSet<>();
                    ips.add(ip);
                    HashMap<Long, HashSet<String>> dateIps = statusDateIPMap.get(status);
                    dateIps.put(foundDate, ips);
                }
            }
        }
    }




    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = getUniqueIPs(after, before);
        return uniqueIPs.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();
        if (after == null && before == null) {
            for (HashSet<String> value : dateIPMap.values()) {
                uniqueIPs.addAll(value);
            }
            return uniqueIPs;
        }

        if (after == null) {
            after = new Date();
            after.setTime(Long.MIN_VALUE);
        }
        if (before == null) {
            before = new Date();
            before.setTime(Long.MAX_VALUE);
        }

        for (Map.Entry<Long, HashSet<String>> ipDateEntry : dateIPMap.entrySet()) {
            if (ipDateEntry.getKey() >= after.getTime() && ipDateEntry.getKey() <= before.getTime()) {
                uniqueIPs.addAll(ipDateEntry.getValue());
            }
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Map<Long, HashSet<String>> ipDateMap = userDateIPMap.get(user);
        return fillContext(ipDateMap, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Map<Long, HashSet<String>> ipDateMap = eventDateIPMap.get(event);
        return fillContext(ipDateMap, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Map<Long, HashSet<String>> ipDateMap = statusDateIPMap.get(status);
        return fillContext(ipDateMap, after, before);
    }

    private Set<String> fillContext(Map<Long, HashSet<String>> ipDateMap, Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();
        if (ipDateMap == null) {
            return null;
        }
        if (after == null && before == null) {
            for (HashSet<String> value : ipDateMap.values()) {
                uniqueIPs.addAll(value);
            }
        }
        if (after == null) {
            after = new Date();
            after.setTime(Long.MIN_VALUE);
        }
        if (before == null) {
            before = new Date();
            before.setTime(Long.MAX_VALUE);
        }
        for (Map.Entry<Long, HashSet<String>> ipDateEntry : ipDateMap.entrySet()) {
            if (ipDateEntry.getKey() >= after.getTime() && ipDateEntry.getKey() <= before.getTime()) {
                uniqueIPs.addAll(ipDateEntry.getValue());
            }
        }
        return uniqueIPs;
    }



    private class ParserFileVisitor extends SimpleFileVisitor<Path> {

        protected ParserFileVisitor() {
            super();
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!Files.isDirectory(file) && file.toString().endsWith(".log")) {
                allLogs.addAll(Files.readAllLines(file));
            }
            return FileVisitResult.CONTINUE;
        }
    }



}