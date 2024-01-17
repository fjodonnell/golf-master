package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.CourseNotFoundException;
import com.projects.golfmaster.model.Course;
import com.projects.golfmaster.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseByName(String courseName) throws CourseNotFoundException {
        Optional<Course> retrievedCourse = courseRepository.findById(courseName);
        return retrievedCourse.orElseThrow(() -> new CourseNotFoundException("Course not Found"));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(String courseName, Course course) throws CourseNotFoundException {
        Optional<Course> retrievedCourse = courseRepository.findById(courseName);
        if (retrievedCourse.isPresent()) {
            Course existingCourse = retrievedCourse.get();
            existingCourse.setCourseName(course.getCourseName());
            existingCourse.setCourseCity(course.getCourseCity());
            existingCourse.setCourseState(course.getCourseState());
            return courseRepository.save(existingCourse);
        } else {
            throw new CourseNotFoundException("Course not Found");
        }
    }


}
