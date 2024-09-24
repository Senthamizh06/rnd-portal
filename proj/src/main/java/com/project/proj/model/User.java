package com.project.proj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "userss")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "designation")
    private String designation;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    @Column(name = "specialization")
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "deptcode", referencedColumnName = "deptcode")  // Foreign key to Department1
    private Department1 department;  // Updated to reflect relation

    

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Department1 getDepartment() {
        return department;
    }

    public void setDepartment(Department1 department) {
        this.department = department;
    }
}
