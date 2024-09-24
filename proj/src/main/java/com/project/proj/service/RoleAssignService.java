package com.project.proj.service;

import com.project.proj.model.RoleAssign;
import com.project.proj.repository.RoleAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleAssignService {

    @Autowired
    private RoleAssignRepository roleAssignRepository;

    // Create role assignment
    public RoleAssign createRoleAssign(RoleAssign roleAssign) {
        Optional<RoleAssign> existingRoleAssign = roleAssignRepository.findByUserId(roleAssign.getUserId());
        if (existingRoleAssign.isPresent()) {
            throw new IllegalArgumentException("User already has a role assigned");
        }
        return roleAssignRepository.save(roleAssign);
    }

    // Update role assignment
    public RoleAssign updateRoleAssign(RoleAssign roleAssign) {
        return roleAssignRepository.save(roleAssign);
    }

    // Delete role assignment
    public void deleteRoleAssignmentByUserIdAndRoleId(String userId, String roleId) {
        roleAssignRepository.deleteByUserIdAndRoleId(userId, roleId);
    }

    // Check if user already has a role
    public Optional<RoleAssign> getUserRole(String userId) {
        return roleAssignRepository.findByUserId(userId);
    }

    // Get role assignment by roleId
    public Optional<RoleAssign> getRoleAssignByRoleId(String roleId) {
        return roleAssignRepository.findByRoleId(roleId);
    }
}
