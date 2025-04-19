package com.skillmentor.core.mapper;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.entity.ClassRoomEntity;
import com.skillmentor.core.entity.MentorEntity;

public class ClassRoomDTOEntityMapper {

    public static ClassRoomDTO map(ClassRoomEntity entity) {
        if (entity == null) return null;

        return new ClassRoomDTO(
                entity.getClassRoomId(),
                entity.getName(),
                entity.getSessionFee(),
                entity.getEnrolledStudentCount(),
                entity.getMentorEntity() != null ? entity.getMentorEntity().getMentorId() : null
        );
    }

    public static ClassRoomEntity map(ClassRoomDTO dto, MentorEntity mentorEntity) {
        if (dto == null) return null;

        return new ClassRoomEntity(
                dto.getClassRoomId(),
                dto.getName(),
                dto.getSessionFee(),
                dto.getEnrolledStudentCount(),
                mentorEntity
        );
    }
}
