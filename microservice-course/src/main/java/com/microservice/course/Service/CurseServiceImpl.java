package com.microservice.course.Service;

import com.microservice.course.Entities.Course;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurseServiceImpl implements ICurseService{

    @Autowired
    private ICurseService curseService;

    @Override
    public List<Course> findAll() {
        return (List<Course>) curseService.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return curseService.findById(id);
    }

    @Override
    public void save(Course course) {
        curseService.save(course);
    }
}
