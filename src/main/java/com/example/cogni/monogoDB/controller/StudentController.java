package com.example.cogni.monogoDB.controller;

import com.example.cogni.monogoDB.entity.StudentDTO;
import com.example.cogni.monogoDB.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

@Autowired
StudentRepository studentRepository;

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
}
