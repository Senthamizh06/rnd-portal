package com.project.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.proj.model.User;

public interface UserInfoRepository extends JpaRepository<User, String> {
    // No additional code is necessary unless you want to define custom query methods
}
