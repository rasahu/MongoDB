package com.example.cogni.monogoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeRecord {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private int age;
    private List<Address> address;
}
