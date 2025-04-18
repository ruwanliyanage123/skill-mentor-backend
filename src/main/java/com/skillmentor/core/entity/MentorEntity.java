package com.skillmentor.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "mentor")
public class MentorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mentor_id")
    private Integer mentorId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "title")
    private String title;
    @Column(name = "profession")
    private String profession;
    @Column(name = "subject")
    private String subject;
    @Column(name = "qualification")
    private String qualification;
    @OneToMany(mappedBy = "mentorEntity")
    @JsonBackReference
    private List<ClassRoomEntity> classRoomEntityList;

    public MentorEntity(Integer mentorId, String firstName, String lastName, String address, String email, String title, String profession, String subject, String qualification) {
        this.mentorId = mentorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.title = title;
        this.profession = profession;
        this.subject = subject;
        this.qualification = qualification;
    }

    public MentorEntity() {
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setClassRoomEntityList(List<ClassRoomEntity> classRoomEntityList) {
        this.classRoomEntityList = classRoomEntityList;
    }

    public List<ClassRoomEntity> getClassRoomEntityList() {
        return classRoomEntityList;
    }
}
