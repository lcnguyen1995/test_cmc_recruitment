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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c")
    , @NamedQuery(name = "Cv.findById", query = "SELECT c FROM Cv c WHERE c.id = :id")
    , @NamedQuery(name = "Cv.findByFirstName", query = "SELECT c FROM Cv c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Cv.findByLastName", query = "SELECT c FROM Cv c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Cv.findByDob", query = "SELECT c FROM Cv c WHERE c.dob = :dob")
    , @NamedQuery(name = "Cv.findByGender", query = "SELECT c FROM Cv c WHERE c.gender = :gender")
    , @NamedQuery(name = "Cv.findByPhone", query = "SELECT c FROM Cv c WHERE c.phone = :phone")
    , @NamedQuery(name = "Cv.findByEmail", query = "SELECT c FROM Cv c WHERE c.email = :email")
    , @NamedQuery(name = "Cv.findByProfileImg", query = "SELECT c FROM Cv c WHERE c.profileImg = :profileImg")
    , @NamedQuery(name = "Cv.findByAddress", query = "SELECT c FROM Cv c WHERE c.address = :address")
    , @NamedQuery(name = "Cv.findByEducation", query = "SELECT c FROM Cv c WHERE c.education = :education")
    , @NamedQuery(name = "Cv.findBySkills", query = "SELECT c FROM Cv c WHERE c.skills = :skills")
    , @NamedQuery(name = "Cv.findByCvUrl", query = "SELECT c FROM Cv c WHERE c.cvUrl = :cvUrl")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "profile_img")
    private String profileImg;
    @Column(name = "address")
    private String address;
    @Column(name = "education")
    private String education;
    @Basic(optional = false)
    @Column(name = "skills")
    private String skills;
    @Lob
    @Column(name = "work_experience")
    private String workExperience;
    @Column(name = "cv_url")
    private String cvUrl;
    @JoinTable(name = "cv_skill", joinColumns = {
        @JoinColumn(name = "cv_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "skill_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Skill> skillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cvId")
    private Collection<Candidate> candidateCollection;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private CvStatus statusId;

    public Cv() {
    }

    public Cv(Long id) {
        this.id = id;
    }

    public Cv(Long id, String skills) {
        this.id = id;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    @XmlTransient
    public Collection<Candidate> getCandidateCollection() {
        return candidateCollection;
    }

    public void setCandidateCollection(Collection<Candidate> candidateCollection) {
        this.candidateCollection = candidateCollection;
    }

    public CvStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(CvStatus statusId) {
        this.statusId = statusId;
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
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Cv[ id=" + id + " ]";
    }
    
}
