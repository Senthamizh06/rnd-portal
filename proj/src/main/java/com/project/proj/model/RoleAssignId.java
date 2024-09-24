package com.project.proj.model;

import java.io.Serializable;
import java.util.Objects;

public class RoleAssignId implements Serializable {
    private String userId;
    private String roleId;

    // Default constructor
    public RoleAssignId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleAssignId)) return false;
        RoleAssignId that = (RoleAssignId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}
