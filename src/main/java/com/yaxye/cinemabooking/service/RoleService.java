package com.yaxye.cinemabooking.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Role;
import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.repository.RoleRepository;
import com.yaxye.cinemabooking.repository.UserRepository;

@Service
public class RoleService {

	private RoleRepository roleRepo;
	private UserRepository userRepo;
	
	@Autowired
	 public RoleService(RoleRepository roleRepo, UserRepository userRepo) {
		super();
		this.roleRepo = roleRepo;
		this.userRepo = userRepo;
	}


	public List<Role> findAll() {
	        return roleRepo.findAll();
	    }

	   
	    public Optional<Role> findById(Long id) {
	        return roleRepo.findById(id);
	    }

	    public void deleteById(Long id) {
	        roleRepo.deleteById(id);

	    }
	   //save role.
		public void saveRole(Role role) {
			Role roleName = roleRepo.findByRoleName(role.getRoleName());
					
		
			if(role.getRoleName().isBlank()) {
				throw new IllegalStateException("Feilds cannot be empty");
			}else if(roleName !=null){
				throw new RuntimeException(" Role already exist: ");
			}else {
				
				roleRepo.save(role);
			}
	            
	        }
		//Assign role to user.
		public void assingUserRole(Long userId, Long roleId) {
			User user = userRepo.findById(userId).orElse(null);
			Role role = roleRepo.findById(roleId).orElse(null);
			Set<Role> userRoles = user.getRoles();
			
			userRoles.add(role);
			user.setRoles(userRoles);
			
			userRepo.save(user);
		}
		
		//unAssing user role.
		public void unassignUserRole(Long userId, Long roleId) {
			User user = userRepo.findById(userId).orElse(null);
			Set<Role> userRoles = user.getRoles();

			//remove role from user.
			userRoles.removeIf(x -> x.getRoleId() == roleId);
			userRepo.save(user);
		}
		
		//get user roles.
		public Set<Role> getUserRoles(User user){
			return user.getRoles();
		}
		public Set<Role> getUserNotRoles(User user){
			   return roleRepo.getUserNotRoles(user.getUserId());
			}
		
}
