package com.microservice.course.Controller;

import com.microservice.course.Entities.Course;
import com.microservice.course.Service.ICurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICurseService iCurseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Course course) {iCurseService.save(course);}

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
        return ResponseEntity.ok(iCurseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){ return ResponseEntity.ok(iCurseService.findById(id));}

@GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Integer idCourse) {
        return ResponseEntity.ok(iCurseService.findStudentsByIdCourse(idCourse));
    }
}
