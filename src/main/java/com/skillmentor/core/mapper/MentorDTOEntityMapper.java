package com.skillmentor.core.mapper;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.entity.MentorEntity;

import java.util.List;

public class MentorDTOEntityMapper {

    public static MentorDTO map(MentorEntity entity) {
        if (entity == null) return null;

        List<ClassRoomDTO> classRoomDTOList = null;
        if (entity.getClassRoomEntityList() != null) {
            classRoomDTOList = entity.getClassRoomEntityList()
                    .stream()
                    .map(ClassRoomDTOEntityMapper::map)
                    .toList();
        }

        return new MentorDTO(
                entity.getMentorId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getTitle(),
                entity.getProfession(),
                entity.getSubject(),
                entity.getQualification(),
                classRoomDTOList
        );
    }

    public static MentorEntity map(MentorDTO dto) {
        if (dto == null) return null;

        return new MentorEntity(
                dto.getMentorId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getTitle(),
                dto.getProfession(),
                dto.getSubject(),
                dto.getQualification()
        );
    }
}
