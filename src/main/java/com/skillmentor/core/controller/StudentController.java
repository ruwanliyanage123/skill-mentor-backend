package com.skillmentor.core.controller;

import com.skillmentor.core.dto.StudentDTO;
import com.skillmentor.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;

@RestController()
@RequestMapping(value = "api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAllStudents(
            @RequestParam(required = false) List<String> firstNames,
            @RequestParam(required = false) List<String> lastNames,
            @RequestParam(required = false) List<String> emails,
            @RequestParam(required = false) List<String> phoneNumbers,
            @RequestParam(required = false) List<Integer> ages
    ) {
        final List<StudentDTO> studentDTOList = studentService.getAllStudents(firstNames, lastNames, emails, phoneNumbers, ages);
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

}
