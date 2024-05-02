package com.example.demo.service.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CourseDTO {
    @NotBlank(message = "Course code is required")
    private String code;
//    @NotBlank(message = "Grade is required")
    private List<GradeDTO> grades;

    public CourseDTO(String code, List<GradeDTO> grades) {
        this.code = code;
        this.grades = grades;
    }
    public CourseDTO(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<GradeDTO> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDTO> grades) {
        this.grades = grades;
    }
}
