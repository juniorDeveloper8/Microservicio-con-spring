package com.microservice.estudiantes.Repositories;

import com.microservice.estudiantes.Entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.courseId = :idCourse")
    List<Student> findAllStudent(Integer idCourse);

    //List<Student> findAllByCourseId(Integer idCourse);
}
