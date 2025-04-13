package com.skillmentor.core.service;

import com.skillmentor.core.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    /**
     * To get all students
     *
     * @param firstNames first name
     * @param lastNames last name
     * @param emails email
     * @param phoneNumbers phone number
     * @param ages age
     * @return all students in the system
     */
    public abstract List<StudentDTO> getAllStudents(List<String> firstNames, List<String> lastNames, List<String> emails, List<String> phoneNumbers, List<Integer> ages);

    /**
     * Get student by id
     *
     * @param studentId student id
     * @return get student id
     */
    public abstract StudentDTO getStudentById(Long studentId);
}
