package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream realStream;

    public AmigoOutputStream (FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.realStream = fileOutputStream;
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
        realStream.flush();
        realStream.write("JavaRush © All rights reserved.".getBytes());
        realStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
