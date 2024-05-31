package com.example.omdaSolutions.EmployeesProject.entity;

import org.springframework.stereotype.Component;

@Component
public class CourseEnrollmentRequest {
    private int studentId;
    private int courseId;

    public CourseEnrollmentRequest() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "CourseEnrollmentRequest{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
