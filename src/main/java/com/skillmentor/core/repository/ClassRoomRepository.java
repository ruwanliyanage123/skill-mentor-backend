package com.skillmentor.core.repository;

import com.skillmentor.core.entity.ClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomEntity, Integer> {
}
