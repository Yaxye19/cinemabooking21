package com.yaxye.cinemabooking.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Role;
import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.repository.RoleRepository;
import com.yaxye.cinemabooking.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleRepository roleRepo;
    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository,
    		RoleRepository roleRepo) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
		/*
		 * User user = userRepository.findByEmail(username); if (user == null) { return
		 * new org.springframework.security.core.userdetails.User( " ", " ", true, true,
		 * true, true, getAuthorities(Arrays.asList( roleRepo.findByRoleName("USER"))));
		 * }
		 */
        	//User user = this.userRepository.findByUsername(username);
        	
      // UserPrincipal userPrincipal = new UserPrincipal(user);
        	  // User userPrincipal = new User(user);
        return this.userRepository.findByUsername(username);
    }


	/*
	 * public Collection<? extends GrantedAuthority> getAuthorities(List<Role> list)
	 * { //Role role = roleRepo.findByRoleName("USER"); List<GrantedAuthority>
	 * authorities = new ArrayList<>();
	 * 
	 * 
	 * for (Role roles : role) { authorities.add(new
	 * SimpleGrantedAuthority(role.getRoleName())); } return authorities; }
	 */
    
}
