package com.skillmentor.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "class_room")
public class ClassRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_room_id")
    private Integer classRoomId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "session_fee", nullable = false)
    private Double sessionFee;
    @Column(name = "enrolled_student_count")
    private Integer enrolledStudentCount;
    @JoinColumn(name = "mentor_id", referencedColumnName = "mentorId")
    private MentorEntity mentorEntity;

    public ClassRoomEntity(Integer classRoomId, String name, Double sessionFee, Integer enrolledStudentCount, MentorEntity mentorEntity) {
        this.classRoomId = classRoomId;
        this.name = name;
        this.sessionFee = sessionFee;
        this.enrolledStudentCount = enrolledStudentCount;
        this.mentorEntity = mentorEntity;
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

    public Integer getEnrolledStudentCount() {
        return enrolledStudentCount;
    }

    public void setEnrolledStudentCount(Integer enrolledStudentCount) {
        this.enrolledStudentCount = enrolledStudentCount;
    }

    public MentorEntity getMentorEntity() {
        return mentorEntity;
    }

    public void setMentorEntity(MentorEntity mentorEntity) {
        this.mentorEntity = mentorEntity;
    }
}
