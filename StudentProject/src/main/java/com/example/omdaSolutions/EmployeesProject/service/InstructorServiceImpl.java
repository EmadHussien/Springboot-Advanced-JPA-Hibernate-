package com.example.omdaSolutions.EmployeesProject.service;

import com.example.omdaSolutions.EmployeesProject.dao.AppDAO;
import com.example.omdaSolutions.EmployeesProject.entity.Course;
import com.example.omdaSolutions.EmployeesProject.entity.Instructor;
import com.example.omdaSolutions.EmployeesProject.entity.InstructorDetail;
import com.example.omdaSolutions.EmployeesProject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final AppDAO appDAO;

    @Autowired
    public InstructorServiceImpl(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        appDAO.save(theInstructor);
    }

    @Override
    public Instructor findInstructorById(Integer theId) {
        return appDAO.findInstructorById(theId);
    }

    @Override
    @Transactional
    public void deleteInstructor(Integer theId) {
        appDAO.deleteInstructor(theId);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer theId) {
        return appDAO.findInstructorDetailById(theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(Integer theId) {
         appDAO.deleteInstructorDetail(theId);
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        appDAO.saveCourse(theCourse);
    }

    @Override
    public Course getSingleCourseWithReviews(Integer theId) {
        return appDAO.getSingleCourseWithReviews(theId);
    }

    @Override
    public Course getSingleCourseWithStudents(Integer theId)
    {
        return appDAO.getSingleCourseWithStudents(theId);
    }
    @Override
    @Transactional
    public void deleteCourseAndReviews(Integer theId) {
        appDAO.deleteCourseAndReviews(theId);
    }

    @Override
    public Student getStudentWithCourses(Integer theId) {
        return appDAO.getStudentWithCourses(theId);
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        appDAO.updateStudent(theStudent);
    }

    @Override
    public void enrollStudentInCourse(Integer studentId, Integer courseId) {
        Student theStudent = appDAO.getStudentWithCourses(studentId);
        System.out.println("this is the student data: "+theStudent);
        Course theCourse = appDAO.findCourseById(courseId);
        System.out.println("this is the course data: "+theCourse);
        theStudent.addCourse(theCourse);
        appDAO.saveStudent(theStudent);


    }

    @Override
    @Transactional
    public void deleteStudentById(Integer theId) {
        appDAO.deleteStudentById(theId);
    }
}
