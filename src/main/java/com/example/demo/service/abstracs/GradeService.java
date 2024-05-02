package com.example.demo.service.abstracs;

import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;

import java.util.List;

public interface GradeService {
    public void calculateAverageGradeForCourses(List<Grade> grades);
}
