package com.example.cogni.monogoDB.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse {
    private int statusCode;
    private String message;

}
