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

    @Autowired(required = true)
    private IStudentService iStudentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent (@RequestBody Student student) {
        iStudentService.save(student);
    }

    public ResponseEntity<?> findAllStudent() {
        return ResponseEntity.ok(iStudentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(iStudentService.findById(id));
    }

    // endpoint para q el microservicios pueda consumirlo
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Integer idCourse){
        return ResponseEntity.ok(iStudentService.findByIdCourse(idCourse));
    }

}
