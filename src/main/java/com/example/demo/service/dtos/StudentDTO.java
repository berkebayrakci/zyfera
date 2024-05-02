package com.example.demo.service.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class StudentDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Surname is required")
    private String surname;
    @NotBlank(message = "Student number is required")
    private String stdNumber;

    private List<GradeDTO> grades;

    public StudentDTO(String name, String surname, String stdNumber, List<GradeDTO> grades) {
        this.name = name;
        this.surname = surname;
        this.stdNumber = stdNumber;
        this.grades = grades;
    }
    public StudentDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(String stdNumber) {
        this.stdNumber = stdNumber;
    }

    public List<GradeDTO> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDTO> grades) {
        this.grades = grades;
    }
}
