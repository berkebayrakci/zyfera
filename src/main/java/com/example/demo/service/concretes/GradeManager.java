package com.example.demo.service.concretes;

import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;
import com.example.demo.repository.GradeRepository;
import com.example.demo.service.abstracs.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeManager implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public void calculateAverageGradeForCourses(List<Grade> grades) {
        Map<String, List<Grade>> gradesByCourseCode = new HashMap<>();

        // Group grades by course code
        for (Grade grade : grades) {
            String courseCode = grade.getCourse().getCode();
            if (!gradesByCourseCode.containsKey(courseCode)) {
                gradesByCourseCode.put(courseCode, new ArrayList<>());
            }
            gradesByCourseCode.get(courseCode).add(grade);
        }

        // Calculate average grade for each course code
        for (Map.Entry<String, List<Grade>> entry : gradesByCourseCode.entrySet()) {
            String courseCode = entry.getKey();
            List<Grade> gradesForCourse = entry.getValue();
            if (gradesForCourse.size() > 1) {
                double totalGrade = 0.0;
                for (Grade grade : gradesForCourse) {
                    totalGrade += grade.getValue();
                }
                double averageGrade = totalGrade / gradesForCourse.size();

                // Update grades with the calculated average value
                for (Grade grade : gradesForCourse) {
                    grade.setValue(averageGrade);
                    gradeRepository.save(grade);
                }
            }
        }
    }
}
