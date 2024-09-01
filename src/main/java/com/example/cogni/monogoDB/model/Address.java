package com.example.cogni.monogoDB.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Address {

    private String city;
    private String state;
    private String country;
}
