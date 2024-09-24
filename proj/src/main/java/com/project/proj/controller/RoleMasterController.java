package com.project.proj.controller;

import com.project.proj.model.RoleMaster;
import com.project.proj.repository.RoleMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/rolemaster")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleMasterController {

    @Autowired
    private RoleMasterRepository roleMasterRepository;

    // Get all roles
    @GetMapping
    public List<RoleMaster> getAllRoles() {
        return roleMasterRepository.findAll();
    }

    // Get a role by ID
    @GetMapping("/{roleId}")
    public ResponseEntity<RoleMaster> getRoleById(@PathVariable("roleId") Long roleId) {
        RoleMaster roleMaster = roleMasterRepository.findById(roleId).orElseThrow();
        return ResponseEntity.ok(roleMaster);
    }

    // Create a new role
    @PostMapping
    public ResponseEntity<RoleMaster> createRole(@Valid @RequestBody RoleMaster roleMaster) {
        RoleMaster createdRole = roleMasterRepository.save(roleMaster);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    // Update a role by ID
    @PutMapping("/{roleId}")
    public ResponseEntity<RoleMaster> updateRole(@PathVariable("roleId") Long roleId, @Valid @RequestBody RoleMaster roleDetails) {
        RoleMaster roleMaster = roleMasterRepository.findById(roleId).orElseThrow();

        boolean isUpdated = false;

        if (!roleMaster.getDescription().equals(roleDetails.getDescription())) {
            roleMaster.setDescription(roleDetails.getDescription());
            isUpdated = true;
        }
        if (!roleMaster.getAuthLevel().equals(roleDetails.getAuthLevel())) {
            roleMaster.setAuthLevel(roleDetails.getAuthLevel());
            isUpdated = true;
        }

        if (isUpdated) {
            roleMaster = roleMasterRepository.save(roleMaster);
        }
        
        return ResponseEntity.ok(roleMaster);
    }

    // Delete a role by ID
    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable("roleId") Long roleId) {
        roleMasterRepository.deleteById(roleId);
        return ResponseEntity.noContent().build();
    }
}
