package com.microservice.course.Service;

import com.microservice.course.Client.StudentClient;
import com.microservice.course.DTO.StudentDTO;
import com.microservice.course.Entities.Course;
import com.microservice.course.Http.response.StudentByCourseResponse;
import com.microservice.course.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurseServiceImpl implements ICurseService{

    @Autowired
    private CourseRepository curseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) curseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return curseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        curseRepository.save(course);
    }
    // aqui se crea la logica para q funcione la conexion entre microservios

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Integer idCourse) {
        // consultamos el curso
        Course courses = curseRepository.findById(idCourse).orElse(new Course());

        //obtener los estudiantes atraves del fein client
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);
        return StudentByCourseResponse.builder()
                //seteamos los datos q vamos a retornar
                .courseName(courses.getName())
                .teacher(courses.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
