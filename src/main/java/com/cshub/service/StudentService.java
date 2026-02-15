package com.cshub.service;

import com.cshub.model.Student;
import com.cshub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static final String SEQUENCE_NAME = "student_sequence";

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public Student registerStudent(Student student) {

        if (studentRepository.existsByRollNo(student.getRollNo())) {
            throw new RuntimeException("Roll number already exists!");
        }

        long seq = sequenceGeneratorService.generateSequence(SEQUENCE_NAME);

        if (seq > 9999) {
            throw new RuntimeException("ID limit exceeded (9999)");
        }

        String customId = String.format("CSHUB%04d", seq);
        student.setId(customId);

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
