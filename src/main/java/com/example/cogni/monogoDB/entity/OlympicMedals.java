package com.example.cogni.monogoDB.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="OlympicMedal")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class OlympicMedals {

    @Id
    private String id;
    private String countryCode;
    private String country;
    private int rank;
    private int gold;
    private int silver;
    private int bronze;
    private int totalMedal;

}
