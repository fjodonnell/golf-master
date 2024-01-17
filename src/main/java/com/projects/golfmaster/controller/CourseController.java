package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.CourseNotFoundException;
import com.projects.golfmaster.model.Course;
import com.projects.golfmaster.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController implements CourseOperations{

    @Autowired
    CourseService courseService;

    @Override
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Override
    public Course getCourseByName(String courseName) throws CourseNotFoundException {
        return courseService.getCourseByName(courseName);
    }

    @Override
    public Course createCourse(Course course) {
        return courseService.createCourse(course);
    }

    @Override
    public Course updateCourse(String courseName, Course course) throws CourseNotFoundException {
        return courseService.updateCourse(courseName, course);
    }
}
