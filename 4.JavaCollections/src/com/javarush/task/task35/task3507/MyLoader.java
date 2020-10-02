package com.javarush.task.task35.task3507;

import java.io.*;

public class MyLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File classFile = new File(name);
        InputStream is = null;
        Class resultClass = null;
        try {
            is = new BufferedInputStream(new FileInputStream(name));
            byte[] bytes = new byte[(int) classFile.length()];
            is.read(bytes);
            resultClass = defineClass(null, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultClass;
    }
}
