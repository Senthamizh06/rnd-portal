package com.project.proj.service;

import com.project.proj.model.ResearchLab;
import com.project.proj.repository.ResearchLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchLabService {

    @Autowired
    private ResearchLabRepository researchLabRepository;

    public ResearchLab addResearchLab(ResearchLab lab) {
        return researchLabRepository.save(lab);
    }

    public List<ResearchLab> getAllLabs() {
        return researchLabRepository.findAll();
    }

    public ResearchLab getLabById(String labId) {
        return researchLabRepository.findById(labId).orElse(null);
    }

    public ResearchLab updateLab(String labId, ResearchLab labDetails) {
        ResearchLab lab = researchLabRepository.findById(labId).orElse(null);
        if (lab != null) {
            lab.setLabName(labDetails.getLabName());
            lab.setLabDesc(labDetails.getLabDesc());
            lab.setLabHead(labDetails.getLabHead());
            return researchLabRepository.save(lab);
        }
        return null;
    }

    public void deleteLab(String labId) {
        researchLabRepository.deleteById(labId);
    }
}