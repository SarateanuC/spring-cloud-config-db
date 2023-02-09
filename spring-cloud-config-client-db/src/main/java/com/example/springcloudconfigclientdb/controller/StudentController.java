package com.example.springcloudconfigclientdb.controller;

import com.example.springcloudconfigclientdb.entity.Student;
import com.example.springcloudconfigclientdb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAll();
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        service.saveStudent(student);
    }
}
