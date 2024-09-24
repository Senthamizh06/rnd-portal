package com.project.proj.model;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_assign1")
@IdClass(RoleAssignId.class)
public class RoleAssign {

    @Id
    @Column(name = "user_id")
    private String userId; // Foreign key from user table

    @Id
    @Column(name = "role_id")
    private String roleId; // Foreign key from role_master table

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

