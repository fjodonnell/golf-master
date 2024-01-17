package com.projects.golfmaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "courses")
@Table(schema = "jpa")
@NoArgsConstructor
@DynamicUpdate
public class Course {

    @Id
    private String courseName;
    private String courseCity;
    private String courseState;

    //Constructor

    public Course(String courseName) {
        this.courseName = courseName;
    }

    //Getters and Setters

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCity() {
        return courseCity;
    }

    public void setCourseCity(String courseCity) {
        this.courseCity = courseCity;
    }

    public String getCourseState() {
        return courseState;
    }

    public void setCourseState(String courseState) {
        this.courseState = courseState;
    }
}
