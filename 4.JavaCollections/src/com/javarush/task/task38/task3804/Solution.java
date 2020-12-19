package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.util.Locale;

public class Solution {
    public static Class getFactoryClass() {
        return FactoryClass.class;
    }

    public enum ttt {DDDD, KKKK}

    public static void main(String[] args) throws Throwable {
        throw FactoryClass.getException(null);
    }

    private static class FactoryClass {
        static Throwable getException(Enum<?> enumValue) {
            if (enumValue == null) {
                return new IllegalArgumentException();
            }
            if ("ApplicationExceptionMessage".equals(enumValue.getDeclaringClass().getSimpleName())) {
                return new Exception(formatExceptionName(enumValue.name()));
            }
            if ("DatabaseExceptionMessage".equals(enumValue.getDeclaringClass().getSimpleName())) {
                return new RuntimeException(formatExceptionName(enumValue.name()));
            }
            if ("UserExceptionMessage".equals(enumValue.getDeclaringClass().getSimpleName())) {
                return new Error(formatExceptionName(enumValue.name()));
            }

            return new IllegalArgumentException();
        }
    }
    private static String formatExceptionName(String exceptionName) {
        exceptionName = exceptionName.replace("_", " ").toLowerCase();
        exceptionName = exceptionName.replaceFirst(exceptionName.substring(0, 1), exceptionName.substring(0, 1).toUpperCase());
        return exceptionName;
    }

}