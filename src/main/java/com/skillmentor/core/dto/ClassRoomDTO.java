package com.skillmentor.core.dto;

public class ClassRoomDTO {
    private Integer classRoomId;
    private String name;
    private Double sessionFee;
    private Integer enrolledStudentCount;
    private MentorDTO mentorDTO;

    public ClassRoomDTO(Integer classRoomId, String name, Double sessionFee, Integer enrolledStudentCount, MentorDTO mentorDTO) {
        this.classRoomId = classRoomId;
        this.name = name;
        this.sessionFee = sessionFee;
        this.enrolledStudentCount = enrolledStudentCount;
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

    public Integer getEnrolledStudentCount() {
        return enrolledStudentCount;
    }
    public void setEnrolledStudentCount(Integer enrolledStudentCount) {
        this.enrolledStudentCount = enrolledStudentCount;
    }

    public MentorDTO getMentorDTO() {
        return mentorDTO;
    }

    public void setMentorDTO(MentorDTO mentorDTO) {
        this.mentorDTO = mentorDTO;
    }
}
