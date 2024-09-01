package com.example.cogni.monogoDB.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="OlympicMedal")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class OlympicMedals {
    private String countryCode;
    private String country;
    private int rank;
    private int gold;
    private int silver;
    private int bronze;

}
