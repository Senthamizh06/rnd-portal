package com.project.proj.controller;

public class ResearchLabDTO {
    private String labId;
    private String labName;
    private String labDesc;
    private String labHeadUserId;

    // Constructor
    public ResearchLabDTO(String labId, String labName, String labDesc, String labHeadUserId) {
        this.labId = labId;
        this.labName = labName;
        this.labDesc = labDesc;
        this.labHeadUserId = labHeadUserId;
    }

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

    public String getLabHeadUserId() {
        return labHeadUserId;
    }

    public void setLabHeadUserId(String labHeadUserId) {
        this.labHeadUserId = labHeadUserId;
    }
}
