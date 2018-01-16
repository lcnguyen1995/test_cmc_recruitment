/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.recruitment.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "skill")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "skillCollection")
    private Set<Request> requestCollection;
    @ManyToMany(mappedBy = "skillCollection")
    private Set<Cv> cvCollection;

    public Skill() {
    }

    public Skill(Long id) {
        this.id = id;
    }

    public Skill(Long id, String title) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Request> getRequestCollection() {
      return requestCollection;
    }

    public void setRequestCollection(Set<Request> requestCollection) {
      this.requestCollection = requestCollection;
    }

    public Set<Cv> getCvCollection() {
      return cvCollection;
    }

    public void setCvCollection(Set<Cv> cvCollection) {
      this.cvCollection = cvCollection;
    }

    @Override
    public String toString() {
        return "demo.Skill[ id=" + id + " ]";
    }
    
}
