package com.skillmentor.core.mapper;

import com.skillmentor.core.dto.StudentDTO;
import com.skillmentor.core.entity.StudentEntity;

public class StudentDTOEntityMapper {
    public static StudentDTO map(StudentEntity studentEntity) {
        if (studentEntity == null) return null;

        return new StudentDTO(
                studentEntity.getStudentId(),
                studentEntity.getFirstName(),
                studentEntity.getLastName(),
                studentEntity.getEmail(),
                studentEntity.getPhoneNumber(),
                studentEntity.getAddress(),
                studentEntity.getAge()
        );
    }

    public static StudentEntity map(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

        return new StudentEntity(
                studentDTO.getStudentId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail(),
                studentDTO.getPhoneNumber(),
                studentDTO.getAddress(),
                studentDTO.getAge()
        );
    }
}
