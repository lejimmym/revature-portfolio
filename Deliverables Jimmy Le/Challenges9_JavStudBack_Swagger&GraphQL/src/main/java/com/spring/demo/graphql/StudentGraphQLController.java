
package com.spring.demo.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.spring.demo.domain.Student;
import com.spring.demo.dto.StudentWriteDto;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentGraphQLController {

    private final StudentService studentService;

    public StudentGraphQLController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public Student student(@Argument Integer id) {
        return studentService.getStudentById(id);
    }

    @MutationMapping
    public Student createStudent(
            @Argument String firstName,
            @Argument String lastName,
            @Argument String email,
            @Argument Integer schoolId) {

        StudentWriteDto dto = new StudentWriteDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setSchoolId(schoolId);

        return studentService.insertStudent(dto);
    }
}
