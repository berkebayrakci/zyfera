# Student API Application

## Overview

The Student API application is developed using the Spring Boot framework. It provides a RESTful endpoint for storing student data in a PostgreSQL database. The application allows creating students along with their grades for different courses. It also calculates and stores the average grade for courses with the same code.

## Create Student Endpoint

- **Endpoint:** POST /api/students
- **Request Body:** JSON object containing student details (name, surname, stdNumber) and an array of grades (code, value).
- **Functionality:**
  - Creates a new student with the provided details and associated grades.
  - Calculates the average grade for courses with the same code and updates the grades accordingly.

## Components

### StudentService

- Responsible for handling business logic related to student operations.
- Provides a method to create a new student with associated grades.

### GradeService

- Handles business logic related to grade operations.
- Provides a method to calculate the average grade for courses with the same code.

### CourseService

- Manages course-related operations such as finding courses by code and creating new courses.

### Repositories

- `StudentRepository`, `GradeRepository`, `CourseRepository`: Interfaces extending JpaRepository for database CRUD operations.

## DTOs (Data Transfer Objects)

- **StudentDTO:** Represents student data transferred between client and server.
- **GradeDTO:** Represents grade data transferred between client and server.

## Entities

- **Student:** Represents a student entity with attributes (name, surname, stdNumber) and a list of grades.
- **Grade:** Represents a grade entity with attributes (code, value) and references to student and course entities.
- **Course:** Represents a course entity with attributes (code) and a list of grades.

## Database Schema

### Student Table

- **Columns:** id (PK), name, surname, stdNumber
- **Relationships:** One-to-many with Grade (student_id)

### Grade Table

- **Columns:** id (PK), value, student_id (FK), course_id (FK)
- **Relationships:** Many-to-one with Student (student_id), Many-to-one with Course (course_id)

### Course Table

- **Columns:** id (PK), code
- **Relationships:** One-to-many with Grade

## Technologies & Dependencies

- Spring Boot: 3.2.5
- Java Version: 17
- Spring Boot Starter Web: For building RESTful APIs.
- Spring Boot Starter Data JPA: For database operations using Spring Data JPA.
- ModelMapper: For mapping DTOs to entities and vice versa.
- Validation: For validations

## Usage

1. Start the application.
2. Send POST requests to `/api/students` with the appropriate JSON payload to create students and their grades.

### Sample Request

```json
{
    "name": "Berke",
    "surname": "Bayrakci",
    "stdNumber": "123412X42",
    "grades": [
        {
            "code": "BB101",
            "value": 90.0
        },
        {
            "code": "PP101",
            "value": 75.0
        },
        {
            "code": "CC101",
            "value": 60.0
        },
        {
            "code": "BB101",
            "value": 70.0
        },
        {
            "code": "SS101",
            "value": 65.0
        }
    ]
}
