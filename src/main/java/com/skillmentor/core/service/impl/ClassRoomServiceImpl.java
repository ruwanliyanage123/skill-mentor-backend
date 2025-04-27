package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.service.ClassRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    public ClassRoomServiceImpl() {
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms(List<String> names, List<Double> fees) {
        return null;
    }

    @Override
    public ClassRoomDTO findClassRoomById(Integer id) {
        return null;
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        return null;
    }

    @Override
    public ClassRoomDTO updateClassRoom(ClassRoomDTO classRoomDTO) {
        return null;
    }

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        return null;
    }
}
