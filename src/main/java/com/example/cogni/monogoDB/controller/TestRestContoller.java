package com.example.cogni.monogoDB.controller;

import com.example.cogni.monogoDB.model.EsignResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class TestRestContoller {

    @GetMapping("/sayHelllo")
    public ResponseEntity<EsignResponse> completeTask() {
        EsignResponse esignResponse = new EsignResponse();
        esignResponse.setMessage("from second Services called By feign Client");
        esignResponse.setStatusCode(200);
        esignResponse.setPackageId("PackageId");
        return new ResponseEntity(esignResponse, HttpStatus.OK);
    }
    @GetMapping("/hello")
    public String helloTask() {
        System.out.println("");
        System.out.println("HU ");
        System.out.println();
        return "Hello World!";
    }
}
