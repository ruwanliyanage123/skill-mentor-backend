package com.skillmentor.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "class_rooms")
public class ClassRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_room_id")
    private Integer classRoomId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "session_fee", nullable = false)
    private Double sessionFee;

    public ClassRoomEntity(Integer classRoomId, String name, Double sessionFee) {
        this.classRoomId = classRoomId;
        this.name = name;
        this.sessionFee = sessionFee;
    }

    public ClassRoomEntity() {
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSessionFee() {
        return sessionFee;
    }

    public void setSessionFee(Double sessionFee) {
        this.sessionFee = sessionFee;
    }
}
