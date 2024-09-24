package com.project.proj.controller;

import com.project.proj.model.ResearchLab;
import com.project.proj.model.User;
import com.project.proj.repository.ResearchLabRepository;
import com.project.proj.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/researchlabs")
@CrossOrigin(origins = "http://localhost:3000")
public class ResearchLabController {

    @Autowired
    private ResearchLabRepository researchLabRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    // Get all labs
    @GetMapping
    public List<ResearchLab> getAllLabs() {
        return researchLabRepository.findAll();
    }

    // Get a lab by ID
    @GetMapping("/{labId}")  // Removed redundant prefix
    public ResponseEntity<ResearchLab> getLabById(@PathVariable String labId) {
        Optional<ResearchLab> lab = researchLabRepository.findById(labId);
        return lab.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new lab
    @PostMapping  // Removed redundant prefix
    public ResponseEntity<ResearchLabDTO> createLab(@RequestBody ResearchLab researchLab) {
        Optional<User> labHeadOptional = userInfoRepository.findById(researchLab.getLabHead().getUserId());

        if (labHeadOptional.isPresent()) {
            researchLab.setLabHead(labHeadOptional.get());
            try {
                ResearchLab savedLab = researchLabRepository.save(researchLab);
                ResearchLabDTO labDTO = new ResearchLabDTO(
                        savedLab.getLabId(),
                        savedLab.getLabName(),
                        savedLab.getLabDesc(),
                        savedLab.getLabHead().getUserId()
                );

                return ResponseEntity.ok(labDTO);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Update a lab
    @PutMapping("/{labId}")  // Removed redundant prefix
    public ResponseEntity<ResearchLab> updateLab(@PathVariable String labId, @RequestBody ResearchLab labDetails) {
        Optional<ResearchLab> existingLab = researchLabRepository.findById(labId);

        if (existingLab.isPresent()) {
            ResearchLab lab = existingLab.get();
            lab.setLabName(labDetails.getLabName());
            lab.setLabDesc(labDetails.getLabDesc());

            // Fetch the labHead (User) based on the provided userId
            Optional<User> labHead = userInfoRepository.findById(labDetails.getLabHead().getUserId());

            if (labHead.isPresent()) {
                lab.setLabHead(labHead.get());
                return ResponseEntity.ok(researchLabRepository.save(lab));
            } else {
                return ResponseEntity.badRequest().body(null);  // Return bad request if labHead not found
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a lab
    @DeleteMapping("/{labId}")
    public ResponseEntity<Void> deleteLab(@PathVariable String labId) {
        Optional<ResearchLab> lab = researchLabRepository.findById(labId);
        if (lab.isPresent()) {
            researchLabRepository.delete(lab.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
