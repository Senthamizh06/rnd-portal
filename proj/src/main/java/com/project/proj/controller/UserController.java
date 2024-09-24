

package com.project.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.proj.model.Department1;
import com.project.proj.repository.UserRepository;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // private static final Logger logger =
    // LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public Department1 newUser(@RequestBody Department1 newUser) {
        // Log the received Userr object

        return userRepository.save(newUser);
    }
    /**
     * @param deptcode
     * @return
     */
    @DeleteMapping("/{deptcode}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer deptcode) {
        CrudRepository<Department1, Integer> departmentRepository;
        if (userRepository.existsById(deptcode)) {
            userRepository.deleteById(deptcode);
            return ResponseEntity.ok(String.format("Department with code %d has been successfully deleted!", deptcode));
        } else {
            return ResponseEntity.status(404).body("Department not found. Please check the department code.");
        }
    }
    @GetMapping
    public List<Department1> getAllDepartments() {
        return userRepository.findAll();
    }
    @PutMapping("/{deptcode}")
    public ResponseEntity<Department1> updateDepartment(@PathVariable Integer deptcode, @RequestBody Department1 updatedDepartment) {
        System.out.println("Updating department with code: " + deptcode);
        System.out.println("Updated department data: " + updatedDepartment);
    
        return userRepository.findById(deptcode)
            .map(department -> {
                department.setDeptname(updatedDepartment.getDeptname());
                department.setDeptdesc(updatedDepartment.getDeptdesc());
                Department1 savedDepartment = userRepository.save(department);
                return ResponseEntity.ok(savedDepartment);
            })
            .orElse(ResponseEntity.status(404).build());
    }
}    