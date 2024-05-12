package com.microservice.estudiantes.Service;

import com.microservice.estudiantes.Entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    List<Student> findByIdCourse(Integer idCourser);
}
