package com.cmc.recruitment.entity;

import java.io.Serializable;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "evaluate_point")
    private Float evaluatePoint;
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cv cvId;
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @ManyToOne
    private Request requestId;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private CandidateStatus statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId")
    @JsonIgnore
    private List<Comment> commentCollection;
    @OneToMany(mappedBy = "candidateId")
    @JsonIgnore
    private List<Interview> interviewCollection;

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

    public List<Interview> getInterviewCollection() {
      return interviewCollection;
    }

    public void setInterviewCollection(List<Interview> interviewCollection) {
      this.interviewCollection = interviewCollection;
    }

    public void setCommentCollection(List<Comment> commentCollection) {
      this.commentCollection = commentCollection;
    }

    @Override
    public String toString() {
        return "demo.Candidate[ id=" + id + " ]";
    }
    
}
