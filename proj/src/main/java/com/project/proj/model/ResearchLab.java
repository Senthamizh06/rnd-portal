package com.project.proj.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "researchlab")
public class ResearchLab implements Serializable {
    @Id
    @Column(name = "lab_id", nullable = false)
    private String labId;

    @Column(name = "lab_name", nullable = false)
    private String labName;

    @Column(name = "lab_desc")
    private String labDesc;

    @ManyToOne
    @JoinColumn(name = "lab_head", referencedColumnName = "user_id")
    private User labHead;

    // Getters and Setters
    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabDesc() {
        return labDesc;
    }

    public void setLabDesc(String labDesc) {
        this.labDesc = labDesc;
    }

    public User getLabHead() {
        return labHead;
    }

    public void setLabHead(User labHead) {
        this.labHead = labHead;
    }
}