package com.project.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.proj.repository.UserRepository;
import com.project.proj.model.Department1;

@Service
public class DepartmentService {

    @Autowired
    private UserRepository departmentRepository;

    public Department1 saveDepartment(Department1 department) {
        return departmentRepository.save(department);
    }

    public boolean deleteDepartment(Integer deptcode) {
        if (departmentRepository.existsById(deptcode)) {
            departmentRepository.deleteById(deptcode);
            return true;
        } else {
            return false;
        }
    }
}
