package com.skillmentor.core.mapper;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.entity.ClassRoomEntity;

public class ClassRoomDTOEntityMapper {
    public static ClassRoomDTO map(ClassRoomEntity entity) {
        if (entity == null) return null;

        return new ClassRoomDTO(
                entity.getClassRoomId(),
                entity.getName(),
                entity.getSessionFee()
        );
    }

    public static ClassRoomEntity map(ClassRoomDTO dto) {
        if (dto == null) return null;

        return new ClassRoomEntity(
                dto.getClassRoomId(),
                dto.getName(),
                dto.getSessionFee()
        );
    }
}
