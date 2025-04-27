package com.skillmentor.core.mapper;

import com.skillmentor.core.entity.StudentEntity;
import com.skillmentor.core.dto.StudentDTO;

public class StudentEntityDTOMapper {

    public static StudentDTO toDTO(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new StudentDTO(
            entity.getStudentId(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getEmail(),
            entity.getPhoneNumber(),
            entity.getAddress(),
            entity.getAge()
        );
    }

    public static StudentEntity toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }
        return new StudentEntity(
            dto.getStudentId(),
            dto.getFirstName(),
            dto.getLastName(),
            dto.getEmail(),
            dto.getPhoneNumber(),
            dto.getAddress(),
            dto.getAge()
        );
    }
}