package com.example.demo.service.concretes;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.abstracs.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseManager implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course findByCode(String code) {
        return courseRepository.findByCode(code);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
