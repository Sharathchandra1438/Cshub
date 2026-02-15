package com.cshub.repository;

import com.cshub.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

    boolean existsByRollNo(String rollNo);
}
