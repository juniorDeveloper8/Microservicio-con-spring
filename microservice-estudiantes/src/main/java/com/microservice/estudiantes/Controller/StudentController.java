package com.microservice.estudiantes.Controller;

import com.microservice.estudiantes.Entities.Student;
import com.microservice.estudiantes.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent (@RequestBody Student student) {
        studentService.save(student);
    }

    public ResponseEntity<?> findAllStudent() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    // endpoint para q el microservicios pueda consumirlo
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Integer idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));
    }

}
