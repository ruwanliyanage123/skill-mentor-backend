package com.skillmentor.core.mapper;
import com.skillmentor.core.dto.MentorDTO;
import com.skillmentor.core.entity.MentorEntity;

public class MentorDTOEntityMapper {

    public static MentorDTO map(MentorEntity entity) {
        if (entity == null) return null;

        return new MentorDTO(
                entity.getMentorId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getTitle(),
                entity.getProfession(),
                entity.getSubject(),
                entity.getQualification()
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
