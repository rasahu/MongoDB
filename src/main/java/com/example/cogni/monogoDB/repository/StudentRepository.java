package com.example.cogni.monogoDB.repository;

import com.example.cogni.monogoDB.entity.StudentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepository extends MongoRepository<StudentDTO,Integer> {}
