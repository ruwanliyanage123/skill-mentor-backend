package com.skillmentor.core.service;

import com.skillmentor.core.dto.MentorDTO;

import java.util.List;

/**
 * Service interface for handling mentor-related business logic.
 * Supports operations like create, read, update, delete (CRUD),
 * and filtered retrieval of mentors.
 */
public interface MentorService {

    /**
     * Retrieves a list of mentors filtered by optional criteria.
     *
     * @param firstNames     optional list of first names to filter by
     * @param lastNames      optional list of last names to filter by
     * @param addresses      optional list of addresses to filter by
     * @param emails         optional list of emails to filter by
     * @param titles         optional list of titles (e.g., Mr., Ms., Dr.) to filter by
     * @param professions    optional list of professions to filter by
     * @param subjects       optional list of subjects to filter by
     * @param qualifications optional list of qualifications to filter by
     * @return a list of {@link MentorDTO} matching the given filters
     */
    List<MentorDTO> getAllMentors(
            List<String> firstNames,
            List<String> lastNames,
            List<String> addresses,
            List<String> emails,
            List<String> titles,
            List<String> professions,
            List<String> subjects,
            List<String> qualifications
    );

    /**
     * Finds a mentor by their unique ID.
     *
     * @param id the unique identifier of the mentor
     * @return the corresponding {@link MentorDTO}, or {@code null} if not found
     */
    MentorDTO findMentorById(Integer id);

    /**
     * Deletes a mentor by ID.
     *
     * @param id the ID of the mentor to delete
     * @return the deleted {@link MentorDTO}, or {@code null} if not found
     */
    MentorDTO deleteMentorById(Integer id);

    /**
     * Updates an existing mentor.
     *
     * @param mentorDTO the updated mentor data
     * @return the updated {@link MentorDTO}, or {@code null} if the mentor does not exist
     */
    MentorDTO updateMentor(MentorDTO mentorDTO);

    /**
     * Creates a new mentor entry.
     *
     * @param mentorDTO the mentor data to create
     * @return the newly created {@link MentorDTO} with an assigned ID
     */
    MentorDTO createMentor(MentorDTO mentorDTO);
}
