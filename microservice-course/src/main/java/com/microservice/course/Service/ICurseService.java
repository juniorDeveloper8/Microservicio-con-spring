package com.microservice.course.Service;

import com.microservice.course.Entities.Course;
import com.microservice.course.Http.response.StudentByCourseResponse;

import java.util.List;

public interface ICurseService {

    List<Course> findAll();

    Course findById(Integer id);

    void save(Course course);

    //metodo para resivir datos de microservicio estudiantes

    StudentByCourseResponse findStudentsByIdCourse(Integer idCourse);
}
