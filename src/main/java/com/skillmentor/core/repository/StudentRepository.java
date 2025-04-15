package com.skillmentor.core.repository;

import com.skillmentor.core.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<StudentEntity, Integer> {

}
