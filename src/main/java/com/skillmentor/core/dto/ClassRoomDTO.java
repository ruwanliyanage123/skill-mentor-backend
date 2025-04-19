package com.skillmentor.core.dto;

public class ClassRoomDTO {
    private Integer classRoomId;
    private String name;
    private Double sessionFee;
    private Integer enrolledStudentCount;
    private Integer mentorId;

    public ClassRoomDTO() {}

    public ClassRoomDTO(Integer classRoomId, String name, Double sessionFee, Integer enrolledStudentCount, Integer mentorId) {
        this.classRoomId = classRoomId;
        this.name = name;
        this.sessionFee = sessionFee;
        this.enrolledStudentCount = enrolledStudentCount;
        this.mentorId = mentorId;
    }

    public Integer getClassRoomId() { return classRoomId; }
    public void setClassRoomId(Integer classRoomId) { this.classRoomId = classRoomId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSessionFee() { return sessionFee; }
    public void setSessionFee(Double sessionFee) { this.sessionFee = sessionFee; }

    public Integer getEnrolledStudentCount() { return enrolledStudentCount; }
    public void setEnrolledStudentCount(Integer enrolledStudentCount) { this.enrolledStudentCount = enrolledStudentCount; }

    public Integer getMentorId() { return mentorId; }
    public void setMentorId(Integer mentorId) { this.mentorId = mentorId; }
}