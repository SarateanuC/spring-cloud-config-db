package com.example.springcloudconfigclientdb.service;

import com.example.springcloudconfigclientdb.entity.Student;
import com.example.springcloudconfigclientdb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public void saveStudent(Student student){
        studentRepository.save(student);
    }
}
