package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.service.MentorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {

    private final List<MentorDTO> mentorDto = new ArrayList<>();

    public MentorServiceImpl() {
        mentorDto.add(new MentorDTO(1, "Nuwan", "Fernando", "Colombo", "nuwan.f@example.com", "Mr.", "Software Engineer", "Java", "BSc in IT", 101));
        mentorDto.add(new MentorDTO(2, "Shehani", "Perera", "Kandy", "shehani.p@example.com", "Ms.", "Senior Developer", "Spring Boot", "MSc in Computer Science", 102));
        mentorDto.add(new MentorDTO(3, "Tharindu", "Silva", "Galle", "tharindu.s@example.com", "Mr.", "DevOps Engineer", "CI/CD", "BEng in Software", 103));
        mentorDto.add(new MentorDTO(4, "Chamara", "Jayasinghe", "Matara", "chamara.j@example.com", "Dr.", "AI Specialist", "Machine Learning", "PhD in AI", 104));
        mentorDto.add(new MentorDTO(5, "Kavindi", "Dissanayake", "Negombo", "kavindi.d@example.com", "Ms.", "UI/UX Designer", "Design Thinking", "BA in Design", 105));
        mentorDto.add(new MentorDTO(6, "Ishara", "Pathirana", "Colombo", "ishara.p@example.com", "Mr.", "Backend Developer", "Node.js", "BSc in CS", 101));
        mentorDto.add(new MentorDTO(7, "Sahan", "Madushanka", "Kurunegala", "sahan.m@example.com", "Mr.", "Data Analyst", "SQL", "BSc in Mathematics", 106));
        mentorDto.add(new MentorDTO(8, "Dinithi", "Wickramasinghe", "Jaffna", "dinithi.w@example.com", "Ms.", "Cybersecurity Expert", "Network Security", "MSc in Cybersecurity", 107));
        mentorDto.add(new MentorDTO(9, "Ravindu", "Senanayake", "Colombo", "ravindu.s@example.com", "Mr.", "Frontend Developer", "React", "BSc in IT", 102));
        mentorDto.add(new MentorDTO(10, "Harsha", "Gunasekara", "Kandy", "harsha.g@example.com", "Dr.", "Database Architect", "PostgreSQL", "PhD in Data Science", 104));
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
        int newId = mentorDto.stream()
                .mapToInt(MentorDTO::getMentorId)
                .max()
                .orElse(0) + 1;
        mentorDTO.setMentorId(newId);
        mentorDto.add(mentorDTO);
        return mentorDTO;
    }
}
