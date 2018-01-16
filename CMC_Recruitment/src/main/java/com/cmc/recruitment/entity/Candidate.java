/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.recruitment.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "candidate")

public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "evaluate_point")
    private Float evaluatePoint;
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cv cvId;
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Request requestId;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CandidateStatus statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "candidateId")
    private Collection<Interview> interviewCollection;

    public Candidate() {
    }

    public Candidate(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getEvaluatePoint() {
        return evaluatePoint;
    }

    public void setEvaluatePoint(Float evaluatePoint) {
        this.evaluatePoint = evaluatePoint;
    }

    public Cv getCvId() {
        return cvId;
    }

    public void setCvId(Cv cvId) {
        this.cvId = cvId;
    }

    public Request getRequestId() {
        return requestId;
    }

    public void setRequestId(Request requestId) {
        this.requestId = requestId;
    }

    public CandidateStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(CandidateStatus statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Interview> getInterviewCollection() {
        return interviewCollection;
    }

    public void setInterviewCollection(Collection<Interview> interviewCollection) {
        this.interviewCollection = interviewCollection;
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
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Candidate[ id=" + id + " ]";
    }
    
}
