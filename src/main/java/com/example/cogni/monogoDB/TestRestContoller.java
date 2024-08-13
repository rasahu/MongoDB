package com.example.cogni.monogoDB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class TestRestContoller {
    @GetMapping("/sayHelllo")
    public ResponseEntity<String> completeTask() {
        return new ResponseEntity("My Name is rakesh", HttpStatus.OK);
    }

}
