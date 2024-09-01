package com.example.cogni.monogoDB.entity;

import com.example.cogni.monogoDB.model.Address;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class StudentDTO {

    private String id;
    private String firstName;
    private String lastName;
    private List<Address> address;
}
