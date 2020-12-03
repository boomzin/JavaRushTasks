package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        System.out.println(logParser.getUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Amigo" ,null, null));
        System.out.println(logParser.getIPsForEvent(Event.LOGIN,null, null));
        System.out.println(logParser.getIPsForStatus(Status.OK,null, null));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, new Date()));
        System.out.println(logParser.getNumberOfUserEvents("Ami", null, null));
        System.out.println(logParser.getUsersForIP("227.0.0.1",null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getDownloadedPluginUsers(null, null));
        System.out.println(logParser.getWroteMessageUsers(null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null, 28));
        System.out.println(logParser.getDoneTaskUsers(null, new Date()));
        System.out.println(logParser.getDoneTaskUsers(null, null, 18));
        System.out.println(logParser.getDatesForUserAndEvent("Amigo", Event.LOGIN, null, new Date()));
        System.out.println(logParser.getDatesWhenSomethingFailed(null, null));
        System.out.println(logParser.getDatesWhenErrorHappened(null, new Date()));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Elly", null, null));
        System.out.println(logParser.getDateWhenUserSolvedTask("Ami", 18, new Date(), null));
        System.out.println(logParser.getDatesWhenUserWroteMessage("Ami", null, new Date()));
        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Diego", null, null));
        System.out.println(logParser.getNumberOfAllEvents(new Date(1325376000000L), new Date(1354320000000L)));
        System.out.println(logParser.getAllEvents(new Date(1325376000000L), new Date(1354320000000L)));
        System.out.println(logParser.getEventsForIP("127.0.0.1", new Date(1325376000000L), new Date(1354320000000L)));
        System.out.println(logParser.getEventsForUser("Ami", new Date(1325376000000L), new Date(1354320000000L)));
        System.out.println(logParser.getFailedEvents(null, null));
        System.out.println(logParser.getErrorEvents(null, null));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));


    }
}