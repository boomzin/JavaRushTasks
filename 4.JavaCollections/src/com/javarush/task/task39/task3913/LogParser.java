package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery {
    private final List<String> logLines = new ArrayList<>();

    public LogParser(Path logDir) {
       File[] listFiles = logDir.toFile().listFiles();
        if (listFiles != null) {
            for (File listFile : listFiles) {
                if (listFile.isFile() && listFile.toString().toLowerCase().endsWith(".log")) {
                    try {
                        logLines.addAll(Files.readAllLines(Paths.get(listFile.toURI())));
                    } catch (IOException e) {
                        System.out.println("Reading log file error" + logLines);
                    }

                }
            }
        }
    }

    private Set<String> selectKeyOnDate(Date after, Date before, String key, KeyType keyType) {
        Set<String> selectedIPsOnDate;
        Stream<String> stringStream = logLines.stream();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        if (after == null && before == null) {
            after = new Date(0L);
            before = new Date(Long.MAX_VALUE);
        }

        if (after == null) {
            after = new Date();
            after.setTime(0L);
        }
        if (before == null) {
            before = new Date();
            before.setTime(Long.MAX_VALUE);
        }
        Stream<String> stringStreamOnKey;
        switch (keyType) {
            case USER:
                stringStreamOnKey = stringStream.filter(x -> (x.split("\t")[1]).contains(key));
                break;
            case EVENT:
                stringStreamOnKey = stringStream.filter(x -> (x.split("\t")[3]).contains(key));
                break;
            case STATUS:
                stringStreamOnKey = stringStream.filter(x -> (x.split("\t")[4]).contains(key));
                break;
            default:
                stringStreamOnKey = stringStream;
        }
        Date finalBefore = before;
        Date finalAfter = after;
        selectedIPsOnDate = stringStreamOnKey
                .filter(x -> {
                    try {
                        return format.parse(x.split("\t")[2]).getTime() <= finalBefore.getTime() &&
                                format.parse(x.split("\t")[2]).getTime() >= finalAfter.getTime();
                    } catch (ParseException e) {
                        System.out.println("Date format parsing error");
                        return false;
                    }
                })
                .map(x -> x.split("\t")[0])
                .collect(Collectors.toSet());

        return selectedIPsOnDate;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return selectKeyOnDate(after, before, "", KeyType.OTHER).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return selectKeyOnDate(after, before, "", KeyType.OTHER);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return selectKeyOnDate(after, before, user, KeyType.USER);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return selectKeyOnDate(after, before, event.name(), KeyType.EVENT);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return selectKeyOnDate(after, before, status.toString(), KeyType.STATUS);
    }

    public enum KeyType {USER, EVENT, STATUS, OTHER}

}
