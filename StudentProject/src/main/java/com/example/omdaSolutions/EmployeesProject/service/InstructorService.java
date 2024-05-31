package com.example.omdaSolutions.EmployeesProject.service;

import com.example.omdaSolutions.EmployeesProject.entity.Course;
import com.example.omdaSolutions.EmployeesProject.entity.Instructor;
import com.example.omdaSolutions.EmployeesProject.entity.InstructorDetail;
import com.example.omdaSolutions.EmployeesProject.entity.Student;

public interface InstructorService {
    void save(Instructor theInstructor);
    Instructor findInstructorById(Integer theId);
    void deleteInstructor(Integer theId);
    InstructorDetail findInstructorDetailById(Integer theId);

    void deleteInstructorDetail(Integer theId);
    void saveCourse(Course theCourse);
    Course getSingleCourseWithReviews(Integer theId);
    Course getSingleCourseWithStudents(Integer theId) ;
    void deleteCourseAndReviews(Integer theId);
    Student getStudentWithCourses(Integer theId);

    void updateStudent(Student theStudent);
    void enrollStudentInCourse(Integer studentId , Integer courseId);
    void deleteStudentById(Integer theId);


}
