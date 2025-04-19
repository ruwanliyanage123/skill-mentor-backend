package com.skillmentor.core.mapper;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.entity.ClassRoomEntity;
import com.skillmentor.core.entity.MentorEntity;

public class ClassRoomDTOEntityMapper {
    public static ClassRoomDTO map(ClassRoomEntity entity) {
        if (entity == null) return null;

        MentorDTO mentorDTO = new MentorDTO(
                entity.getMentorEntity().getMentorId(),
                entity.getMentorEntity().getFirstName(),
                entity.getMentorEntity().getLastName(),
                entity.getMentorEntity().getAddress(),
                entity.getMentorEntity().getEmail(),
                entity.getMentorEntity().getTitle(),
                entity.getMentorEntity().getProfession(),
                entity.getMentorEntity().getSubject(),
                entity.getMentorEntity().getQualification());

        return new ClassRoomDTO(
                entity.getClassRoomId(),
                entity.getName(),
                entity.getSessionFee(),
                entity.getEnrolledStudentCount(),
                mentorDTO
        );
    }

    public static ClassRoomEntity map(ClassRoomDTO dto) {
        if (dto == null) return null;

        MentorEntity mentorEntity = new MentorEntity(
                dto.getMentorDTO().getMentorId(),
                dto.getMentorDTO().getFirstName(),
                dto.getMentorDTO().getLastName(),
                dto.getMentorDTO().getAddress(),
                dto.getMentorDTO().getEmail(),
                dto.getMentorDTO().getTitle(),
                dto.getMentorDTO().getProfession(),
                dto.getMentorDTO().getSubject(),
                dto.getMentorDTO().getQualification());

        return new ClassRoomEntity(
                dto.getClassRoomId(),
                dto.getName(),
                dto.getSessionFee(),
                dto.getEnrolledStudentCount(),
                mentorEntity
        );
    }
}
