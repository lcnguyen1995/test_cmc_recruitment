/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.recruitment.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
   
    @Column(name = "email")
    private String email;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "avatar_url")
    private String avatarUrl;
   
    @Column(name = "is_active")
    private Boolean isActive;
   
    @ManyToMany(mappedBy = "userCollection")
    @JsonIgnore
    private Set<Interview> interviewCollection;
    
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleCollection;
   
    @JsonIgnore
    @OneToMany(mappedBy = "assigneeId")
    private List<Request> requestCollection;
   
    @JsonIgnore
    @OneToMany(mappedBy = "createdBy")
    private List<Request> requestCollection1;
    
    @JsonIgnore
    @OneToMany(mappedBy = "editedBy")
    private List<Request> requestCollection2;
   
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Comment> commentCollection;
    
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne
    private Department departmentId;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Interview> getInterviewCollection() {
      return interviewCollection;
    }

    public void setInterviewCollection(Set<Interview> interviewCollection) {
      this.interviewCollection = interviewCollection;
    }

    public Set<Role> getRoleCollection() {
      return roleCollection;
    }

    public void setRoleCollection(Set<Role> roleCollection) {
      this.roleCollection = roleCollection;
    }

    public List<Request> getRequestCollection() {
      return requestCollection;
    }

    public void setRequestCollection(List<Request> requestCollection) {
      this.requestCollection = requestCollection;
    }

    public List<Request> getRequestCollection1() {
      return requestCollection1;
    }

    public void setRequestCollection1(List<Request> requestCollection1) {
      this.requestCollection1 = requestCollection1;
    }

    public List<Request> getRequestCollection2() {
      return requestCollection2;
    }

    public void setRequestCollection2(List<Request> requestCollection2) {
      this.requestCollection2 = requestCollection2;
    }

    public List<Comment> getCommentCollection() {
      return commentCollection;
    }

    public void setCommentCollection(List<Comment> commentCollection) {
      this.commentCollection = commentCollection;
    }

    public Department getDepartmentId() {
      return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
      this.departmentId = departmentId;
    }

    @Override
    public String toString() {
      return "User [id=" + id + ", username=" + username + "]";
    }
}
