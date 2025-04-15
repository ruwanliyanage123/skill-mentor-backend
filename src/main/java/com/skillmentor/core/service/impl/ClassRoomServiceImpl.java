package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.entity.ClassRoomEntity;
import com.skillmentor.core.mapper.ClassRoomDTOEntityMapper;
import com.skillmentor.core.repository.ClassRoomRepository;
import com.skillmentor.core.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    public ClassRoomServiceImpl() {
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms(List<String> names, List<Double> fees) {
        final List<ClassRoomEntity> classRooms = classRoomRepository.findAll();
        return classRooms.stream()
                .filter(c -> names == null || names.isEmpty() || names.contains(c.getName()))
                .filter(c -> fees == null || fees.isEmpty() || fees.contains(c.getSessionFee()))
                .map(ClassRoomDTOEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public ClassRoomDTO findClassRoomById(Integer id) {
        return classRoomRepository.findById(id).map(ClassRoomDTOEntityMapper::map).orElse(null);
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        final Optional<ClassRoomEntity> classRoomEntityOptional = classRoomRepository.findById(id);
        if (classRoomEntityOptional.isPresent()) {
            classRoomRepository.deleteById(id);
            return ClassRoomDTOEntityMapper.map(classRoomEntityOptional.get());
        }
        return null;
    }

    @Override
    public ClassRoomDTO updateClassRoom(ClassRoomDTO classRoomDTO) {
        final Optional<ClassRoomEntity> classRoomEntityOptional = classRoomRepository.findById(classRoomDTO.getClassRoomId());
        if (classRoomEntityOptional.isPresent()) {
            classRoomRepository.save(ClassRoomDTOEntityMapper.map(classRoomDTO));
            return classRoomDTO;
        }
        return null;
    }

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        final ClassRoomEntity classRoomEntity = classRoomRepository.save(ClassRoomDTOEntityMapper.map(classRoomDTO));
        return ClassRoomDTOEntityMapper.map(classRoomEntity);
    }
}
