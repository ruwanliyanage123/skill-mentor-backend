package com.skillmentor.core.service;

import com.skillmentor.core.dto.StudentDTO;

import java.util.List;

/**
 * Service interface for managing students.
 * Provides operations to create, retrieve, and update student records.
 */
public interface StudentService {

    /**
     * Retrieves a list of students filtered by optional criteria.
     *
     * @param firstNames   optional list of first names to filter
     * @param lastNames    optional list of last names to filter
     * @param emails       optional list of email addresses to filter
     * @param phoneNumbers optional list of phone numbers to filter
     * @param ages         optional list of ages to filter
     * @return a list of {@link StudentDTO} matching the filters
     */
    List<StudentDTO> getAllStudents(
            List<String> firstNames,
            List<String> lastNames,
            List<String> emails,
            List<String> phoneNumbers,
            List<Integer> ages
    );

    /**
     * Retrieves a student by their ID.
     *
     * @param studentId the unique ID of the student
     * @return the matching {@link StudentDTO}, or {@code null} if not found
     */
    StudentDTO getStudentById(Integer studentId);

    /**
     * Creates a new student record.
     *
     * @param studentDTO the student data to create
     * @return the created {@link StudentDTO} with generated ID
     */
    StudentDTO createStudent(StudentDTO studentDTO);

    /**
     * Updates an existing student record.
     *
     * @param studentDTO the updated student data
     * @return the updated {@link StudentDTO}, or {@code null} if the student does not exist
     */
    StudentDTO updateStudent(StudentDTO studentDTO);
}
