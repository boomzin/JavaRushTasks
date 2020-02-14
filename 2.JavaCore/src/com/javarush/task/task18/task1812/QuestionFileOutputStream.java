package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream realStream;

    public QuestionFileOutputStream (AmigoOutputStream amigoOutputStream) {
        this.realStream = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        realStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        realStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        realStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        realStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (answer.equals("Д")) {
            realStream.close();
        }
    }
}

