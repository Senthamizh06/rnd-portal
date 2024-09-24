package com.project.proj.controller;

import com.project.proj.service.RoleAssignService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.proj.model.RoleAssign;





@RestController
@RequestMapping("/api")
public class AssignRoleController {

    @Autowired
    private RoleAssignService roleAssignService;

    // Create role assignment
    @PostMapping("/assign-role")
    public ResponseEntity<RoleAssign> createRoleAssign(@RequestBody RoleAssign roleAssign) {
        try {
            RoleAssign createdRoleAssign = roleAssignService.createRoleAssign(roleAssign);
            return ResponseEntity.ok(createdRoleAssign);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Check if user has a role
    @GetMapping("/check-user-role")
    public ResponseEntity<RoleAssign> checkUserRole(@RequestParam String userId) {
        Optional<RoleAssign> roleAssign = roleAssignService.getUserRole(userId);
        return roleAssign.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete role assignment
     // Delete all role assignments by roleId
     @DeleteMapping("/assign-role")
     public ResponseEntity<Void> deleteRoleAssignment(@RequestParam String roleId, @RequestParam String userId) {
         roleAssignService.deleteRoleAssignmentByUserIdAndRoleId(userId, roleId);
         return ResponseEntity.noContent().build();
     }

    // Update role assignment
    @PutMapping("/assign-role")
    public ResponseEntity<RoleAssign> updateRoleAssign(@RequestBody RoleAssign roleAssign) {
        RoleAssign updatedRoleAssign = roleAssignService.updateRoleAssign(roleAssign);
        return ResponseEntity.ok(updatedRoleAssign);
    }

    // Retrieve role assignment details
    @GetMapping("/assign-role")
    public ResponseEntity<RoleAssign> getRoleAssign(@RequestParam String roleId) {
        Optional<RoleAssign> roleAssign = roleAssignService.getRoleAssignByRoleId(roleId);
        return roleAssign.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
