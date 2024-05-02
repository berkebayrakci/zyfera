package com.example.demo.service.abstracs;

import com.example.demo.entity.Course;

public interface CourseService {
    public Course findByCode(String code);
    public Course createCourse(Course course);
}
