package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.StudentDTO;
import com.skillmentor.core.entity.StudentEntity;
import com.skillmentor.core.mapper.StudentDTOEntityMapper;
import com.skillmentor.core.repository.StudentRepository;
import com.skillmentor.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl() {
    }

    @Override
    public List<StudentDTO> getAllStudents(List<String> firstNames, List<String> lastNames, List<String> emails, List<String> phoneNumbers, List<Integer> ages) {
        final List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities.stream()
                .filter(stu -> firstNames == null || firstNames.isEmpty() || firstNames.contains(stu.getFirstName()))
                .filter(stu -> lastNames == null || lastNames.isEmpty() || lastNames.contains(stu.getLastName()))
                .filter(stu -> emails == null || emails.isEmpty() || emails.contains(stu.getEmail()))
                .filter(stu -> phoneNumbers == null || phoneNumbers.isEmpty() || phoneNumbers.contains(stu.getPhoneNumber()))
                .filter(stu -> ages == null || ages.isEmpty() || ages.contains(stu.getAge()))
                .map(StudentDTOEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Integer studentId) {
        final Optional<StudentEntity> studentDTOOptional = studentRepository.findById(studentId);
        return studentDTOOptional.map(StudentDTOEntityMapper::map).orElse(null);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        studentRepository.save(StudentDTOEntityMapper.map(studentDTO));
        return studentDTO;
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        final Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentDTO.getStudentId());
        if (studentEntityOptional.isPresent()) {
            studentRepository.save(StudentDTOEntityMapper.map(studentDTO));
            return studentDTO;
        }
        return null;
    }
}
