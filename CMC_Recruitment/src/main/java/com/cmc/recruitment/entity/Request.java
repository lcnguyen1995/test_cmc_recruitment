/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.recruitment.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "request")

public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "major")
    private String major;
    @Column(name = "others")
    private String others;
    @Column(name = "salary")
    private String salary;
    @Column(name = "benefit")
    private String benefit;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "edited_date")
    @Temporal(TemporalType.DATE)
    private Date editedDate;
    @Column(name = "published_date")
    @Temporal(TemporalType.DATE)
    private Date publishedDate;
    @Column(name = "education")
    private String education;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "year_of_experience")
    private String yearOfExperience;
    @Column(name = "cv_deadline")
    @Temporal(TemporalType.DATE)
    private Date cvDeadline;
    @JoinTable(name = "request_skill", joinColumns = {
        @JoinColumn(name = "request_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "skill_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Skill> skillCollection;
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Position positionId;
    @JoinColumn(name = "request_status_id", referencedColumnName = "id")
    @ManyToOne
    private RequestStatus requestStatusId;
    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    @ManyToOne
    private User assigneeId;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private User createdBy;
    @JoinColumn(name = "edited_by", referencedColumnName = "id")
    @ManyToOne
    private User editedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<Candidate> candidateCollection;

    public Request() {
    }

    public Request(Long id) {
        this.id = id;
    }

    public Request(Long id, String title, int number, String description) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.description = description;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public Date getCvDeadline() {
        return cvDeadline;
    }

    public void setCvDeadline(Date cvDeadline) {
        this.cvDeadline = cvDeadline;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public RequestStatus getRequestStatusId() {
        return requestStatusId;
    }

    public void setRequestStatusId(RequestStatus requestStatusId) {
        this.requestStatusId = requestStatusId;
    }

    public User getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(User assigneeId) {
        this.assigneeId = assigneeId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(User editedBy) {
        this.editedBy = editedBy;
    }

    @XmlTransient
    public Collection<Candidate> getCandidateCollection() {
        return candidateCollection;
    }

    public void setCandidateCollection(Collection<Candidate> candidateCollection) {
        this.candidateCollection = candidateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Request[ id=" + id + " ]";
    }
    
}
