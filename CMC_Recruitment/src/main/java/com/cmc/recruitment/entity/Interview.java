/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.recruitment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "interview")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "time")
    private Date time;
    @Column(name = "location")
    private String location;
    @Column(name = "note")
    private String note;
    
    @ManyToMany
    @JoinTable(name = "assignee_interview", joinColumns = {
        @JoinColumn(name = "interview_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> userCollection;
    
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne
    private Candidate candidateId;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private InterviewStatus statusId;

    public Interview() {
    }

    public Interview(Long id) {
        this.id = id;
    }

    public Interview(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public void setUserCollection(Set<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Candidate candidateId) {
        this.candidateId = candidateId;
    }

    public InterviewStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(InterviewStatus statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "demo.Interview[ id=" + id + " ]";
    }
    
}
