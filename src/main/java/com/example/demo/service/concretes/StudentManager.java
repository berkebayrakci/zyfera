package com.example.demo.service.concretes;

import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.abstracs.CourseService;
import com.example.demo.service.abstracs.GradeService;
import com.example.demo.service.abstracs.StudentService;
import com.example.demo.service.dtos.GradeDTO;
import com.example.demo.service.dtos.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseService courseService;

    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        List<Grade> grades = new ArrayList<>();

        for (GradeDTO gradeDTO : studentDTO.getGrades()) {
            Grade grade = modelMapper.map(gradeDTO, Grade.class);

            // Check if the course already exists, if not, create it
            Course course = courseService.findByCode(gradeDTO.getCode());
            if (course == null) {
                course = new Course();
                course.setCode(gradeDTO.getCode());
                course = courseService.createCourse(course); // Save the course
            }

            grade.setCourse(course);
            grade.setStudent(student);
            grades.add(grade);
        }
        student.setGrades(grades);
        studentRepository.save(student);

        // Calculate average grade for courses with the same code
        gradeService.calculateAverageGradeForCourses(grades);

        return modelMapper.map(student, StudentDTO.class);
    }
}
