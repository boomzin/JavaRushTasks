package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);
            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            User user = new User();
            user.setLastName("Petrov");
            user.setBirthDate(new GregorianCalendar(1988, 0, 3).getTime());
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.equals(javaRush));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (this.users.size() > 0) {
                for (int i = 0; i < users.size(); i++) {
                    User it = users.get(i);
                    String birthDate = null;
                    if (it.getBirthDate() != null) {
                        birthDate = String.valueOf(it.getBirthDate().getTime());
                    }
                    bufferedWriter.write(it.getFirstName() + "#" + it.getLastName() + "#" + birthDate + "#" + it.isMale() + "#" + it.getCountry() + System.lineSeparator());
                }
                bufferedWriter.close();
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String userLine;
            while ((userLine = bufferedReader.readLine()) != null) {
                User tempUser = new User();
                String [] userData =  userLine.split("#");
                if (!"null".equals(userData[0])) {
                    tempUser.setFirstName(userData[0]);
                }
                if (!"null".equals(userData[1])) {
                    tempUser.setLastName(userData[1]);
                }
                if (!"null".equals(userData[2])) {
                    tempUser.setBirthDate(new Date(Long.parseLong(userData[2])));
                }
                if (!"null".equals(userData[3])) {
                    tempUser.setMale(Boolean.parseBoolean(userData[3]));
                }
                if (!"null".equals(userData[4])) {
                    switch (userData[4]) {
                        case "RUSSIA": tempUser.setCountry(User.Country.RUSSIA);
                        break;
                        case "UKRAINE": tempUser.setCountry(User.Country.UKRAINE);
                        break;
                        case "OTHER": tempUser.setCountry(User.Country.OTHER);
                    }
                }
                this.users.add(tempUser);
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
