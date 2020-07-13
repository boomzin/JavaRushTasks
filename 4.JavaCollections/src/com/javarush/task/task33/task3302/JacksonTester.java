package com.javarush.task.task33.task3302;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonRawValue;

public class JacksonTester {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = new Student("Mark", 1, "{\"attr\":false}");
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Student {
    private String name;
    private int rollNo;
//    @JsonRawValue
    private String json;
    public Student(String name, int rollNo, String json) {
        this.name = name;
        this.rollNo = rollNo;
        this.json = json;
    }
    public String getName(){
        return name;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getJson(){
        return json;
    }
}