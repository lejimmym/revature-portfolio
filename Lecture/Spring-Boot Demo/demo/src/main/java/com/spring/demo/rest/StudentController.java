package com.spring.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.demo.domain.Student;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
     
    // //Get localhost
    // @GetMapping("path")
    // public List<Student> getAllStudents(){
    //     return 
    // }


    // @PostMapping
    // public ResponseEntity<Student> postMethodName(@RequestBody String entity) {
    //     //TODO: process POST request
        
    //     return entity;
    // }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.insertStudent(student);

        return ResponseEntity
            .created(
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedStudent.getId())
                    .toUri()
            )
            .body(savedStudent);
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    
    
    
}
