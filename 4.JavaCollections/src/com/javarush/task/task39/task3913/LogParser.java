package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.DateQuery;
import com.javarush.task.task39.task3913.query.EventQuery;
import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;
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

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery {
    public enum KeyType {IP, USER, DATE, EVENT, STATUS, OTHER}
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

    private Set<Event> convertStringSetToEventSet(Set<String> stringSet) {
        Set<Event> eventSet = new HashSet<>();
        for (String s : stringSet) {
            if (s.contains(" ")) {
                s = s.substring(0, s.lastIndexOf(" "));
            }
            eventSet.add(Event.valueOf(s));
        }
        return eventSet;
    }

    private Set<Date> convertStringSetToDateSet(Set<String> stringSet) {
        Set<Date> dateResults = new HashSet<>();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        for (String s : stringSet) {
            try {
                dateResults.add(format.parse(s));
            } catch (ParseException e) {
                System.out.println("Date format parsing error in convertStringSetToDateSet method");
            }
        }
        return dateResults;
    }

    private Set<String> selectResultByKeys(Date after, Date before, String key1, KeyType keyType1, String key2, KeyType keyType2, KeyType result) {
        Set<String> selectedResults;
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
        Stream<String> stringStreamOnKey1;
        switch (keyType1) {
            case USER:
                stringStreamOnKey1 = stringStream.filter(x -> (x.split("\t")[1]).equals(key1));
                break;
            case EVENT:
                stringStreamOnKey1 = stringStream.filter(x -> (x.split("\t")[3]).contains(key1));
                break;
            case STATUS:
                stringStreamOnKey1 = stringStream.filter(x -> (x.split("\t")[4]).contains(key1));
                break;
            case IP:
                stringStreamOnKey1 = stringStream.filter(x -> (x.split("\t")[0]).contains(key1));
                break;
            default:
                stringStreamOnKey1 = stringStream;
        }
        Stream<String> stringStreamOnKey2;
        switch (keyType2) {
            case USER:
                stringStreamOnKey2 = stringStreamOnKey1.filter(x -> (x.split("\t")[1]).equals(key2));
                break;
            case EVENT:
                stringStreamOnKey2 = stringStreamOnKey1.filter(x -> (x.split("\t")[3]).contains(key2));
                break;
            case STATUS:
                stringStreamOnKey2 = stringStreamOnKey1.filter(x -> (x.split("\t")[4]).contains(key2));
                break;
            case IP:
                stringStreamOnKey2 = stringStreamOnKey1.filter(x -> (x.split("\t")[0]).contains(key2));
                break;
            default:
                stringStreamOnKey2 = stringStreamOnKey1;
        }
        Date finalBefore = before;
        Date finalAfter = after;
        selectedResults = stringStreamOnKey2
                .filter(x -> {
                    try {
                        return format.parse(x.split("\t")[2]).getTime() <= finalBefore.getTime() &&
                                format.parse(x.split("\t")[2]).getTime() >= finalAfter.getTime();
                    } catch (ParseException e) {
                        System.out.println("Date format parsing error in selectResultByKeys method");
                        return false;
                    }
                })
                .map(x -> x.split("\t")[result.ordinal()])
                .collect(Collectors.toSet());

        return selectedResults;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return selectResultByKeys(after, before, "", KeyType.OTHER, "", KeyType.OTHER, KeyType.IP).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return selectResultByKeys(after, before, "", KeyType.OTHER, "", KeyType.OTHER, KeyType.IP);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return selectResultByKeys(after, before, user, KeyType.USER, "", KeyType.OTHER, KeyType.IP);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return selectResultByKeys(after, before, event.name(), KeyType.EVENT, "", KeyType.OTHER, KeyType.IP);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return selectResultByKeys(after, before, status.toString(), KeyType.STATUS, "", KeyType.OTHER, KeyType.IP);
    }

    @Override
    public Set<String> getAllUsers() {
        return selectResultByKeys(null, null, null, KeyType.OTHER, "", KeyType.OTHER, KeyType.USER);
    }


    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return selectResultByKeys(after, before, null, KeyType.OTHER, "", KeyType.OTHER, KeyType.USER).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return selectResultByKeys(after, before, user, KeyType.USER, "", KeyType.OTHER, KeyType.EVENT).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return selectResultByKeys(after, before, ip, KeyType.IP, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return selectResultByKeys(after, before, "LOGIN", KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return selectResultByKeys(after, before, "DOWNLOAD_PLUGIN", KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return selectResultByKeys(after, before, "WRITE_MESSAGE", KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return selectResultByKeys(after, before, "SOLVE_TASK", KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int taskNumber) {
        return selectResultByKeys(after, before, "SOLVE_TASK " + taskNumber, KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return selectResultByKeys(after, before, "DONE_TASK", KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int taskNumber) {
        return selectResultByKeys(after, before, "DONE_TASK " + taskNumber, KeyType.EVENT, "", KeyType.OTHER, KeyType.USER);
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return convertStringSetToDateSet(selectResultByKeys(after, before, user, KeyType.USER, event.toString(), KeyType.EVENT, KeyType.DATE ));
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return convertStringSetToDateSet(selectResultByKeys(after, before, "FAILED", KeyType.STATUS, "", KeyType.OTHER, KeyType.DATE));
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return convertStringSetToDateSet(selectResultByKeys(after, before, "ERROR", KeyType.STATUS, "", KeyType.OTHER, KeyType.DATE));
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        if (selectResultByKeys(after, before, user, KeyType.USER, "LOGIN", KeyType.EVENT, KeyType.DATE).size() == 0) {
            return null;
        }
        TreeSet<Date> sortedDates = new TreeSet<>(convertStringSetToDateSet(selectResultByKeys(after, before, user, KeyType.USER, "LOGIN", KeyType.EVENT, KeyType.DATE)));
        return sortedDates.first();
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        if (selectResultByKeys(after, before, user, KeyType.USER, "SOLVE_TASK " + task, KeyType.EVENT, KeyType.DATE).size() == 0) {
            return null;
        }
        TreeSet<Date> sortedDates = new TreeSet<>(convertStringSetToDateSet(selectResultByKeys(after, before, user, KeyType.USER, "SOLVE_TASK " + task, KeyType.EVENT, KeyType.DATE)));
        return sortedDates.first();
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        if (selectResultByKeys(after, before, user, KeyType.USER, "DONE_TASK " + task, KeyType.EVENT, KeyType.DATE).size() == 0) {
            return null;
        }
        TreeSet<Date> sortedDates = new TreeSet<>(convertStringSetToDateSet(selectResultByKeys(after, before, user, KeyType.USER, "DONE_TASK " + task, KeyType.EVENT, KeyType.DATE)));
        return sortedDates.first();
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return convertStringSetToDateSet(selectResultByKeys(after, before, user, KeyType.USER, "WRITE_MESSAGE", KeyType.EVENT, KeyType.DATE));
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return convertStringSetToDateSet(selectResultByKeys(after, before, user, KeyType.USER, "DOWNLOAD_PLUGIN", KeyType.EVENT, KeyType.DATE));
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return convertStringSetToEventSet(selectResultByKeys(after, before, "", KeyType.EVENT, "", KeyType.OTHER, KeyType.EVENT)).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return convertStringSetToEventSet(selectResultByKeys(after, before, "", KeyType.EVENT, "", KeyType.OTHER, KeyType.EVENT));
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return convertStringSetToEventSet(selectResultByKeys(after, before, ip, KeyType.IP, "", KeyType.OTHER, KeyType.EVENT));
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return convertStringSetToEventSet(selectResultByKeys(after, before, user, KeyType.USER, "", KeyType.OTHER, KeyType.EVENT));
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return convertStringSetToEventSet(selectResultByKeys(after, before, "FAILED", KeyType.STATUS, "", KeyType.OTHER, KeyType.EVENT));
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return convertStringSetToEventSet(selectResultByKeys(after, before, "ERROR", KeyType.STATUS, "", KeyType.OTHER, KeyType.EVENT));
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return selectResultByKeys(after, before, "SOLVE_TASK " + task, KeyType.EVENT, "", KeyType.OTHER, KeyType.DATE).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return 0;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return null;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return null;
    }
}
