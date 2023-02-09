package com.example.springcloudconfigclientdb.repository;

import com.example.springcloudconfigclientdb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
