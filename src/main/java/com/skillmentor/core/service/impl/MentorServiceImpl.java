package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.mapper.MentorDTOEntityMapper;
import com.skillmentor.core.repository.MentorRepository;
import com.skillmentor.core.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    private final List<MentorDTO> mentorDto = new ArrayList<>();

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

        return mentorDto.stream()
                .filter(mentor -> firstNames == null || firstNames.isEmpty() || firstNames.contains(mentor.getFirstName()))
                .filter(mentor -> lastNames == null || lastNames.isEmpty() || lastNames.contains(mentor.getLastName()))
                .filter(mentor -> addresses == null || addresses.isEmpty() || addresses.contains(mentor.getAddress()))
                .filter(mentor -> emails == null || emails.isEmpty() || emails.contains(mentor.getEmail()))
                .filter(mentor -> titles == null || titles.isEmpty() || titles.contains(mentor.getTitle()))
                .filter(mentor -> professions == null || professions.isEmpty() || professions.contains(mentor.getProfession()))
                .filter(mentor -> subjects == null || subjects.isEmpty() || subjects.contains(mentor.getSubject()))
                .filter(mentor -> qualifications == null || qualifications.isEmpty() || qualifications.contains(mentor.getQualification()))
                .collect(Collectors.toList());
    }

    @Override
    public MentorDTO findMentorById(Integer id) {
        return mentorDto.stream()
                .filter(m -> m.getMentorId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        Optional<MentorDTO> mentorOptional = mentorDto.stream()
                .filter(m -> m.getMentorId().equals(id))
                .findFirst();
        mentorOptional.ifPresent(mentorDto::remove);
        return mentorOptional.orElse(null);
    }

    @Override
    public MentorDTO updateMentor(MentorDTO updatedMentor) {
        for (int i = 0; i < mentorDto.size(); i++) {
            if (mentorDto.get(i).getMentorId().equals(updatedMentor.getMentorId())) {
                mentorDto.set(i, updatedMentor);
                return updatedMentor;
            }
        }
        return null;
    }

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        mentorRepository.save(MentorDTOEntityMapper.map(mentorDTO));
        return mentorDTO;
    }
}
