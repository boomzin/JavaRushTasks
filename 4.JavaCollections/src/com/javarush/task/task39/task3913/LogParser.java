package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LogParser implements IPQuery {
    private final List<String> logLines = new ArrayList<>();


    public LogParser(Path logDir) {
       File[] listFiles = logDir.toFile().listFiles();
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

    private Stream selectOnDate(Date after, Date before, String key) {
        Stream<String> allLines = logLines.stream();
        if (after == null && before == null) {
            return allLines;
        }

        if (after == null) {
            after = new Date();
            after.setTime(Long.MIN_VALUE);
        }
        if (before == null) {
            before = new Date();
            before.setTime(Long.MAX_VALUE);
        }



        return null;
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        System.out.println(logLines);
        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}
