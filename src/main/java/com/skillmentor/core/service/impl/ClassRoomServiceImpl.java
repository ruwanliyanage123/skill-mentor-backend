package com.skillmentor.core.service.impl;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.service.ClassRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final List<ClassRoomDTO> classrooms = new ArrayList<>();

    public ClassRoomServiceImpl() {
        classrooms.add(new ClassRoomDTO(1, "Math Class", 1000.0));
        classrooms.add(new ClassRoomDTO(2, "English Class", 1200.0));
        classrooms.add(new ClassRoomDTO(3, "Science Class", 1100.0));
        classrooms.add(new ClassRoomDTO(4, "History Class", 950.0));
        classrooms.add(new ClassRoomDTO(5, "IT Class", 1300.0));
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms(List<String> names, List<Double> fees) {
        return classrooms.stream()
                .filter(c -> names == null || names.isEmpty() || names.contains(c.getName()))
                .filter(c -> fees == null || fees.isEmpty() || fees.contains(c.getSessionFee()))
                .collect(Collectors.toList());
    }

    @Override
    public ClassRoomDTO findClassRoomById(Integer id) {
        return classrooms.stream()
                .filter(c -> c.getClassRoomId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        Optional<ClassRoomDTO> optional = classrooms.stream()
                .filter(c -> c.getClassRoomId().equals(id))
                .findFirst();
        optional.ifPresent(classrooms::remove);
        return optional.orElse(null);
    }

    @Override
    public ClassRoomDTO updateClassRoom(ClassRoomDTO updated) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getClassRoomId().equals(updated.getClassRoomId())) {
                classrooms.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO newClassroom) {
        int newId = classrooms.stream()
                .mapToInt(ClassRoomDTO::getClassRoomId)
                .max()
                .orElse(0) + 1;

        newClassroom.setClassRoomId(newId);
        classrooms.add(newClassroom);
        return newClassroom;
    }
}
