package com.yaxye.cinemabooking.service;

import com.yaxye.cinemabooking.entity.Film;
import com.yaxye.cinemabooking.entity.Role;
import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.repository.RoleRepository;
import com.yaxye.cinemabooking.repository.TicketRepository;
import com.yaxye.cinemabooking.repository.UserRepository;
import com.yaxye.cinemabooking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
	
	@Autowired
    private final UserRepository userRepository;
	@Autowired
    private final RoleRepository roleRepo;
	
	@Autowired
    private final TicketRepository ticketRepository;
	
	@Autowired
    private final BCryptPasswordEncoder encoder;

    
    public UserService(UserRepository userRepository, TicketRepository ticketRepository, 
    		BCryptPasswordEncoder encoder, RoleRepository roleRepo ) {
        this.userRepository = userRepository;
		this.roleRepo = roleRepo;
        this.ticketRepository = ticketRepository;
        this.encoder = encoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

	public void saveUser(User user) {
		User email = userRepository.findByEmail(user.getEmail());

		
		//Role UserRole = roleRepo.findByRoleName("USER");
		if(user.getFirstName().isBlank() || user.getLastName().isBlank() || user.getEmail().isBlank()
				|| user.getPhone().isBlank() || user.getPassword().isBlank()) {
			throw new IllegalStateException("Feilds cannot be empty");
		}else if(email !=null){
			throw new RuntimeException(" Email is taken: ");
		}else {
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setActive(1);
		user.setusername(user.getEmail());
		
		Role roleUser = roleRepo.findByRoleName("USER");
		user.addRole(roleUser);
			userRepository.save(user);
		}
            
    }
	  //Update film details.
		@Transactional
		public User updateUser(@RequestBody User user, 
				@RequestParam(required = false) String password,
				@RequestParam(required = false) String username) {
			User existingUser = userRepository.getById(user.getUserId());
				existingUser.setUserId(user.getUserId());
				existingUser.setFirstName(user.getFirstName());
				existingUser.setLastName(user.getLastName());
				existingUser.setusername(user.getEmail());
				existingUser.setEmail(user.getEmail());
				existingUser.setPhone(user.getPhone());
			//	existingUser.setPassword(encoder.encode(user.getPassword()));
			
				return userRepository.save(user);
			
		}
		  public void deleteUserById(Long id) {
			
		        if (getUserById(id) != null) {
		            userRepository.deleteById(id);
		        }
		    }

		  public Optional<User> getUserById(Long id) {  
		    	Optional <User> userId = userRepository.findById(id);
		    		
		    	if(userId == null) {
		    		throw new IllegalStateException(
		  					userId +	 
		  				"  Does not exist."); 
		    	}else
		        return userRepository.findById(id);
		    }
		  public User findUserById(Long userId) {
				
				return userRepository.getById(userId);
			}
	}
