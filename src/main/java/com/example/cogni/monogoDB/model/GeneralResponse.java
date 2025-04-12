package com.example.cogni.monogoDB.model;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse  {
	private int statusCode;
	private String message;

}
