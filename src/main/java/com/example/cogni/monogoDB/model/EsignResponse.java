package com.example.cogni.monogoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsignResponse  extends  GeneralResponse{
   private String packageId;
}
