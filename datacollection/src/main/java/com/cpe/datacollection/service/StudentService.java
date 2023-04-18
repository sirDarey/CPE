package com.cpe.datacollection.service;

import com.cpe.datacollection.model.Student;
import com.cpe.datacollection.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
