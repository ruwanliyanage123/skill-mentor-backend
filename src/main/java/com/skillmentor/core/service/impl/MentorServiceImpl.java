package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.service.MentorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    public MentorServiceImpl() {
    }

    @Override
    public List<MentorDTO> getAllMentors(
            List<String> firstNames,
            List<String> lastNames,
            List<String> addresses,
            List<String> emails,
            List<String> titles,
            List<String> professions,
            List<String> subjects,
            List<String> qualifications) {

        return null;
    }

    @Override
    public MentorDTO findMentorById(Integer id) {
        return null;
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        return null;
    }

    @Override
    public MentorDTO updateMentor(MentorDTO mentorDTO) {
        return null;
    }

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        return null;
    }
}
