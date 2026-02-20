package com.projects.golfmaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@DynamicUpdate
@Data
public class Course {

    @Id
    private String courseName;
    private String courseCity;
    private String courseState;
    private Integer coursePar;
    private Integer courseLength;

    //Constructor

    public Course(String courseName) {
        this.courseName = courseName;
    }
}
