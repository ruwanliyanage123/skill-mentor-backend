package com.skillmentor.core.controller;

import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<MentorDTO> findMentorById(@PathVariable Integer id){
        final MentorDTO mentorDTO = mentorService.findMentorById(id);
        return new ResponseEntity<>(mentorDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentorDTO> deleteMentorById(@PathVariable Integer id){
        final MentorDTO mentorDTO =  mentorService.deleteMentorById(id);
        return new ResponseEntity<>(mentorDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO){
        final MentorDTO mentor = mentorService.createMentor(mentorDTO);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MentorDTO> updateMentor(@RequestBody MentorDTO mentorDTO){
        final MentorDTO mentor = mentorService.updateMentor(mentorDTO);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }
}
