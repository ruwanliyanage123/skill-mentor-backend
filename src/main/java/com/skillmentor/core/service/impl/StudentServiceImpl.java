package com.skillmentor.core.service.impl;

import com.skillmentor.core.dao.StudentDAO;
import com.skillmentor.core.dto.StudentDTO;
import com.skillmentor.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public StudentServiceImpl() {
    }

    @Override
    public List<StudentDTO> getAllStudents(List<String> firstNames, List<String> lastNames, List<String> emails, List<String> phoneNumbers, List<Integer> ages) {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return null;
    }

    @Override
    public StudentDTO getStudentById(Integer studentId) {
        return null;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentDTO student = studentDAO.createStudent(studentDTO);
        return student;
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return studentDAO.updateStudent(studentDTO);
    }
}
