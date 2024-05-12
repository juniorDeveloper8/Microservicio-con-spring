package com.microservice.course.Service;

import com.microservice.course.Entities.Course;

import java.util.List;

public interface ICurseService {

    List<Course> findAll();

    Course findById(Integer id);

    void save(Course course);
}
