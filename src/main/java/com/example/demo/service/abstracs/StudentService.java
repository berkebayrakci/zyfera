package com.example.demo.service.abstracs;

import com.example.demo.service.dtos.StudentDTO;
import org.springframework.http.HttpStatus;

public interface StudentService {
    public StudentDTO createStudent(StudentDTO studentDTO);
}
