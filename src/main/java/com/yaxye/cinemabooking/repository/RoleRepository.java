package com.yaxye.cinemabooking.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	//Role findById(Long id);

	Role findByRoleName(String roleName);
	
	@Query(
	        value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)", 
	        nativeQuery = true
	)
	Set<Role> getUserNotRoles(Long userId);
	
}
