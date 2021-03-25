package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/

public class Solution {
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("The server is currently not accessible.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("The server is currently not accessible.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("The user is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("The user is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("The user is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("The user is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public final static class Constants {
        public final static Exception SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = new Exception("The server is currently not accessible.");
        public final static Exception USER_IS_NOT_AUTHORIZED = new Exception("The user is not authorized.");
        public final static Exception USER_IS_BANNED = new Exception("The user is banned.");
        public final static Exception ACCESS_IS_DENIED = new Exception("Access is denied.");
    }

    public static void main(String[] args) {

    }
}
