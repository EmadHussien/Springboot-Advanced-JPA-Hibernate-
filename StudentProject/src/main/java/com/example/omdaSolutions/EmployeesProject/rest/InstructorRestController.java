package com.example.omdaSolutions.EmployeesProject.rest;

import com.example.omdaSolutions.EmployeesProject.entity.*;
import com.example.omdaSolutions.EmployeesProject.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class InstructorRestController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorRestController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @PostMapping("/instructors")
    public void saveInstructor(@RequestBody Instructor theInstructor)
    {
        System.out.println(theInstructor.toString());
        instructorService.save(theInstructor);
    }
    @GetMapping("/instructors/{theId}")
    public Instructor getSingleInstructor(@PathVariable Integer theId)
    {
        System.out.println(theId);
        Instructor theInstructor = instructorService.findInstructorById(theId);
        System.out.println(theInstructor);

        return theInstructor;

    }

    @DeleteMapping("/instructors/{theId}")
    public void removeInstructorById(@PathVariable Integer theId)
    {
        System.out.println(theId);
        instructorService.deleteInstructor(theId);
    }


    @GetMapping("/instructors-details/{theId}")
    public InstructorDetail getSingleInstructorDetail(@PathVariable Integer theId)
    {
        System.out.println(theId);
        InstructorDetail instructorDetail = instructorService.findInstructorDetailById(theId);
        System.out.println(instructorDetail);
        return instructorDetail;
    }

    @DeleteMapping("/instructors-details/{theId}")
    public void removeInstructorDetailById(@PathVariable Integer theId)
    {
        System.out.println(theId);
        instructorService.deleteInstructorDetail(theId);
    }

    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course theCourse)
    {
        System.out.println(theCourse);
        System.out.println(theCourse.getStudents());
        instructorService.saveCourse(theCourse);
    }
    @GetMapping("courses/{theId}")
    public Course getCourseById(@PathVariable Integer theId)
    {
       // return instructorService.getSingleCourseWithReviews(theId);
        return instructorService.getSingleCourseWithStudents(theId);
    }
    @DeleteMapping("courses/{theId}")
    public void deleteCourseAndReviews(@PathVariable Integer theId)
    {
        instructorService.deleteCourseAndReviews(theId);
    }

    @GetMapping("students/{theId}")
    public Student getStudentAndCoursesById(@PathVariable Integer theId)
    {
        return instructorService.getStudentWithCourses(theId);
    }
    @PutMapping("students/{theId}")
    public void getStudentAndCoursesById(@PathVariable Integer theId, @RequestBody Student theStudent)
    {
        System.out.println(theStudent);
        System.out.println(theStudent.getCourses());
        theStudent.setId(theId);
        instructorService.updateStudent(theStudent);
    }

    @DeleteMapping("students/{theId}")
    public void deleteStudentById(@PathVariable Integer theId)
    {
        instructorService.deleteStudentById(theId);
    }
    @PostMapping("course-enrollment")
    public void enrollStudentInCourse(@RequestBody CourseEnrollmentRequest courseEnrollmentRequest)
    {
        System.out.println(courseEnrollmentRequest);
        instructorService.enrollStudentInCourse(courseEnrollmentRequest.getStudentId(),courseEnrollmentRequest.getCourseId());
    }

}
