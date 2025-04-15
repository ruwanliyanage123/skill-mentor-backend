package com.skillmentor.core.controller;

import com.skillmentor.core.dto.StudentDTO;
import com.skillmentor.core.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Validated
@RestController()
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAllStudents(
            @RequestParam(required = false) List<String> firstNames,
            @RequestParam(required = false) List<String> lastNames,
            @RequestParam(required = false) List<String> emails,
            @RequestParam(required = false) List<String> phoneNumbers,
            @RequestParam(required = false) @Size(min = 18, max = 30) List<Integer> ages
    ) {
        final List<StudentDTO> studentDTOList = studentService.getAllStudents(firstNames, lastNames, emails, phoneNumbers, ages);
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") @Min(10) @Max(15) Integer id){
        final StudentDTO studentDTO = studentService.getStudentById(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        final StudentDTO student = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody @Valid StudentDTO studentDTO){
        final StudentDTO student = studentService.updateStudent(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
