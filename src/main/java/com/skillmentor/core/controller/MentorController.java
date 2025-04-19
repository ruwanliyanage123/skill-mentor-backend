package com.skillmentor.core.controller;

import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.exception.MentorNotFoundException;
import com.skillmentor.core.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity<List<MentorDTO>> getAllMentor(
            @RequestParam(required = false) List<String> firstNames,
            @RequestParam(required = false) List<String> lastNames,
            @RequestParam(required = false) List<String> addresses,
            @RequestParam(required = false) List<String> emails,
            @RequestParam(required = false) List<String> titles,
            @RequestParam(required = false) List<String> professions,
            @RequestParam(required = false) List<String> subjects,
            @RequestParam(required = false) List<String> qualifications)
    {
        final List<MentorDTO> mentorDTOList = mentorService.getAllMentors(firstNames, lastNames, addresses, emails, titles, professions, subjects, qualifications);
        return new ResponseEntity<>(mentorDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> findMentorById(@PathVariable Integer id) {
        MentorDTO mentorDTO = mentorService.findMentorById(id);
        if (mentorDTO == null) {
            throw new MentorNotFoundException("Mentor with ID " + id + " not found");
        }
        return ResponseEntity.ok(mentorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentorDTO> deleteMentorById(@PathVariable Integer id) {
        if (id <1) {
            throw new MentorNotFoundException("Cannot delete, Mentor with ID " + id + " not found");
        }
        MentorDTO mentorDTO = mentorService.deleteMentorById(id);
        return ResponseEntity.ok(mentorDTO);
    }

    @PostMapping
    public ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO) {
        final MentorDTO mentor = mentorService.createMentor(mentorDTO);
        return new ResponseEntity<>(mentor, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MentorDTO> updateMentor(@RequestBody MentorDTO mentorDTO) {
        final MentorDTO mentor = mentorService.updateMentor(mentorDTO);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }
}
