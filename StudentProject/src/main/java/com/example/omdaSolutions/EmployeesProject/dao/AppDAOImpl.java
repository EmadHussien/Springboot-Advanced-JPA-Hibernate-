package com.example.omdaSolutions.EmployeesProject.dao;

import com.example.omdaSolutions.EmployeesProject.entity.Course;
import com.example.omdaSolutions.EmployeesProject.entity.Instructor;
import com.example.omdaSolutions.EmployeesProject.entity.InstructorDetail;
import com.example.omdaSolutions.EmployeesProject.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager)
    {
        this.entityManager = theEntityManager;
    }
    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(Integer theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    public void deleteInstructor(Integer theId) {
        Instructor theInstructor = entityManager.find(Instructor.class,theId);
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    public void deleteInstructorDetail(Integer theId) {
        var theInstructorDetail =  entityManager.find(InstructorDetail.class,theId);
        theInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(theInstructorDetail);
    }

    @Override
    public void saveCourse(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course getSingleCourseWithReviews(Integer theId) {
        // better way to do it for better performance select all at once together
        TypedQuery<Course> theQuery= entityManager.createQuery(
                "select c from Course c "+
                        "JOIN FETCH c.reviews "+
                        "where c.id = :data"
        , Course.class);
        theQuery.setParameter("data",theId);
        return theQuery.getSingleResult();

        //return entityManager.find(Course.class,theId);
    }

    @Override
    public void deleteCourseAndReviews(Integer theId) {
        Course course = entityManager.find(Course.class,theId);

        entityManager.remove(course);
    }

    @Override
    public Course getSingleCourseWithStudents(Integer theId) {
        // better way to do it for better performance select all at once together
        TypedQuery<Course> theQuery= entityManager.createQuery(
                "select c from Course c "+
                        "JOIN FETCH c.students "+
                        "where c.id = :data"
                , Course.class);
        theQuery.setParameter("data",theId);
        return theQuery.getSingleResult();

        //return entityManager.find(Course.class,theId);
    }

    @Override
    public Student getStudentWithCourses(Integer theId) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "select s from Student s "+
                        "JOIN FETCH s.courses "+
                        "where s.id = :data"
                        ,Student.class
        );
        theQuery.setParameter("data",theId);
        return theQuery.getSingleResult();

    }

    @Override
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    public void enrollStudentInCourse(Integer studentId, Integer courseId) {

    }

    @Override
    public Course findCourseById(Integer theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public void deleteStudentById(Integer theId) {
        Student theStudent = entityManager.find(Student.class,theId);
        entityManager.remove(theStudent);
    }


}
