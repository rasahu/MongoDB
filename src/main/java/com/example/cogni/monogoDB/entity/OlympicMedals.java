package com.example.cogni.monogoDB.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "country code can't be null or Empty")
    @Size(min=3 ,max = 3,message = "Country Code must be three Character long")
    private String countryCode;
    @NotBlank(message = "country can't be null or Empty")
    private String country;
    private int rank;
    private int gold;
    private int silver;
    private int bronze;
    private int totalMedal;

    @NotBlank(message = "The Zip code is required.")
    @Pattern(regexp = "^\\d{1,5}$", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE },
                          message = "The Zip code is invalid.")
    private String zipCode;
}
