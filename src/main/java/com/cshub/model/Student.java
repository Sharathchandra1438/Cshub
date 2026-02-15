package com.cshub.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    @NotBlank
    private String rollNo;

    @NotBlank
    private String name;

    @NotBlank
    private String branch;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    private Year year;   // Now this refers to your enum

    @Email
    private String email;
}
