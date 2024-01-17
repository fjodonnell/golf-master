package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.CourseNotFoundException;
import com.projects.golfmaster.model.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
public interface CourseOperations {

    @GetMapping("/")
    List<Course> getAllCourses();

    @GetMapping("/{courseName}")
    Course getCourseByName(@PathVariable String courseName) throws CourseNotFoundException;

    @PostMapping("/create")
    Course createCourse(@RequestBody Course course);

    @PutMapping("/{courseName}")
    Course updateCourse(@PathVariable String courseName, @RequestBody Course course) throws CourseNotFoundException;
}
