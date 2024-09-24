package com.project.proj.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.proj.model.RoleAssign;
import com.project.proj.model.RoleAssignId;

import jakarta.transaction.Transactional;

@Repository
public interface RoleAssignRepository extends JpaRepository<RoleAssign, RoleAssignId> {
    

    Optional<RoleAssign> findByUserId(String userId);

    Optional<RoleAssign> findByRoleId(String roleId);
    @Modifying
    @Transactional
    @Query("DELETE FROM RoleAssign ra WHERE ra.userId = :userId AND ra.roleId = :roleId")
    void deleteByUserIdAndRoleId(String userId, String roleId);
}
