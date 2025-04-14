package com.skillmentor.core.controller;

import com.skillmentor.core.dto.ClassRoomDTO;
import com.skillmentor.core.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/classroom")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping
    public ResponseEntity<List<ClassRoomDTO>> getAllClassRooms(
            @RequestParam(required = false) List<String> names,
            @RequestParam(required = false) List<Double> fees
    ) {
        return ResponseEntity.ok(classRoomService.getAllClassRooms(names, fees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> findClassRoomById(@PathVariable Integer id) {
        ClassRoomDTO dto = classRoomService.findClassRoomById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> deleteClassRoom(@PathVariable Integer id) {
        ClassRoomDTO dto = classRoomService.deleteClassRoomById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ClassRoomDTO> createClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        return ResponseEntity.ok(classRoomService.createClassRoom(classRoomDTO));
    }

    @PutMapping
    public ResponseEntity<ClassRoomDTO> updateClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        return ResponseEntity.ok(classRoomService.updateClassRoom(classRoomDTO));
    }
}
