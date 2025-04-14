package com.skillmentor.core.dto;

public class ClassRoomDTO {
    private Integer classRoomId;
    private String name;
    private Double sessionFee;

    public ClassRoomDTO(Integer classRoomId, String name, Double sessionFee) {
        this.classRoomId = classRoomId;
        this.name = name;
        this.sessionFee = sessionFee;
    }

    public ClassRoomDTO() {
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
