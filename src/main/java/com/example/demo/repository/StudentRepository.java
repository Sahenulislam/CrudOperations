package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {


   List<Student> findAllBySection(String section);

   Page<Student> findAllBySection(String section, Pageable pageable);
}

