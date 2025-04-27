package com.skillmentor.core.dao;

import com.skillmentor.core.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Data Access Object (DAO) interface for managing Student entities.
 * Provides methods for CRUD operations on Student data.
 */
@Component
public interface StudentDAO {

    /**
     * Creates a new student record in the database.
     *
     * @param studentDTO the StudentDTO object containing student details to be saved
     */
    StudentDTO createStudent(StudentDTO studentDTO);

    /**
     * Retrieves a student record by its unique ID.
     *
     * @param studentId the unique ID of the student to retrieve
     * @return the StudentDTO object containing the student's details, or null if not found
     */
    StudentDTO getStudentById(Integer studentId);

    /**
     * Retrieves all student records from the database.
     *
     * @return a list of StudentDTO objects containing details of all students
     */
    List<StudentDTO> getAllStudents();

    /**
     * Updates an existing student record in the database.
     *
     * @param studentDTO the StudentDTO object containing updated student details
     */
    StudentDTO updateStudent(StudentDTO studentDTO);

    /**
     * Deletes a student record from the database by its unique ID.
     *
     * @param studentId the unique ID of the student to delete
     */
    StudentDTO deleteStudent(Integer studentId);
}