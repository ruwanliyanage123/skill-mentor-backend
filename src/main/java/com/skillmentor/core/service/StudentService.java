package com.skillmentor.core.service;

import com.skillmentor.core.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public abstract List<StudentDTO> getAllStudents();
}
