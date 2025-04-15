package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.entity.MentorEntity;
import com.skillmentor.core.mapper.MentorDTOEntityMapper;
import com.skillmentor.core.repository.MentorRepository;
import com.skillmentor.core.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {
    @Autowired
    private MentorRepository mentorRepository;

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

        final List<MentorEntity> mentorDto = mentorRepository.findAll();
        return mentorDto.stream()
                .filter(mentor -> firstNames == null || firstNames.isEmpty() || firstNames.contains(mentor.getFirstName()))
                .filter(mentor -> lastNames == null || lastNames.isEmpty() || lastNames.contains(mentor.getLastName()))
                .filter(mentor -> addresses == null || addresses.isEmpty() || addresses.contains(mentor.getAddress()))
                .filter(mentor -> emails == null || emails.isEmpty() || emails.contains(mentor.getEmail()))
                .filter(mentor -> titles == null || titles.isEmpty() || titles.contains(mentor.getTitle()))
                .filter(mentor -> professions == null || professions.isEmpty() || professions.contains(mentor.getProfession()))
                .filter(mentor -> subjects == null || subjects.isEmpty() || subjects.contains(mentor.getSubject()))
                .filter(mentor -> qualifications == null || qualifications.isEmpty() || qualifications.contains(mentor.getQualification()))
                .map(MentorDTOEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public MentorDTO findMentorById(Integer id) {
        Optional<MentorEntity> mentorEntityOptional = mentorRepository.findById(id);
        return mentorEntityOptional.map(MentorDTOEntityMapper::map).orElse(null);
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        Optional<MentorEntity> mentorEntityOptional = mentorRepository.findById(id);
        if(mentorEntityOptional.isPresent()){
            mentorRepository.deleteById(id);
            return MentorDTOEntityMapper.map(mentorEntityOptional.get());
        }
        return null;
    }

    @Override
    public MentorDTO updateMentor(MentorDTO mentorDTO) {
        Optional<MentorEntity> mentorEntityOptional = mentorRepository.findById(mentorDTO.getMentorId());
        if(mentorEntityOptional.isPresent()){
            mentorRepository.save(MentorDTOEntityMapper.map(mentorDTO));
            return mentorDTO;
        }
        return null;
    }

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        mentorRepository.save(MentorDTOEntityMapper.map(mentorDTO));
        return mentorDTO;
    }
}
