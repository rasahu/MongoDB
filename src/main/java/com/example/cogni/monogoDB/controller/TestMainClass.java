package com.example.cogni.monogoDB.controller;

import java.time.LocalDateTime;

public class TestMainClass {
    private String generateFileName(String fileName) {
        String dateTime = LocalDateTime.now().toString();
        System.out.println(dateTime);
        dateTime = dateTime.substring(0, dateTime.indexOf('.'))
                .replace('-', '.')
                .replace('T', '-')
                .replace(':', '.');
        return fileName + "-" + dateTime;
        // FILENAME-yyyy.MM.dd-hh.mm-ss
    }
    public static void main(String[] args) {
        TestMainClass mainClass=new TestMainClass();
        System.out.println(mainClass.generateFileName("file.text"));
    }
}
