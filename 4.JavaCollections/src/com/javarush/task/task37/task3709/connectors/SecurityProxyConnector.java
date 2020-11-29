package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SecurityProxyConnector implements Connector{
    private SimpleConnector simpleConnector;
    private SecurityChecker securityChecker = new SecurityCheckerImpl();


    public SecurityProxyConnector(String s) {
        simpleConnector = new SimpleConnector(s);
    }

    @Override
    public void connect() {
        PrintStream printStream = System.out;
        PrintStream printStream1 = new PrintStream(new ByteArrayOutputStream());
        System.setOut(printStream1);
        if (securityChecker.performSecurityCheck()) {
            System.setOut(printStream);
            simpleConnector.connect();
        }

    }
}
