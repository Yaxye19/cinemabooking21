package com.yaxye.cinemabooking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yaxye.cinemabooking.entity.Film;
import com.yaxye.cinemabooking.entity.Role;
import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.service.FilmService;
import com.yaxye.cinemabooking.service.RoleService;

@RestController
@RequestMapping(name = "roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    
	//gets all the roles
	
    @RequestMapping(value = "roles", method = RequestMethod.GET)
    public ModelAndView allRoles() {
		ModelAndView mav = new ModelAndView("Users/role");
        mav.addObject("roles", roleService.findAll());
        return mav;
    }
    
 // Show role form before creating one.
	
	@RequestMapping(value = "showroles", method = RequestMethod.GET)
	public ModelAndView showRoles() {
		ModelAndView mav = new ModelAndView("Users/new_role");
		Role roles = new Role();
		mav.addObject("role",roles);
		
		return mav;
	
	}
	// Show User before creating one.
	
	@GetMapping(value = "showrole")
	public ModelAndView showRoleForm() {
		ModelAndView mav = new ModelAndView("Users/new_role");
		Role role = new Role();
		mav.addObject("role",role);
		
		return mav;
	
	}
	
	//add role
	@RequestMapping(value = "addrole", method = RequestMethod.POST)
	public RedirectView saveRole(@ModelAttribute("role") Role role) {
		roleService.saveRole(role);
		
		RedirectView redirectView = new RedirectView("role", true);
		return redirectView;		
		
	}
    
	
	@RequestMapping(value = "role", method = RequestMethod.GET, params = {"roleId"})
    public String getRoleEdit(@RequestParam Long roleId, Model model) {
        model.addAttribute("role", roleService.findById(roleId));
        		
        return "role";
    }
	
	//get role form for editing it
	
		@GetMapping("editRole/{id}")
		public ModelAndView editRoleForm(@PathVariable("id") Long roleId, Model model) {
			Optional<Role> role = this.roleService.findById(roleId);
			
		ModelAndView mav = new ModelAndView("Users/update-role");
		model.addAttribute("role", role);
		
		return mav;
			
		}
	// update cinema.
	/*
		@RequestMapping(value ="updatefilm/{id}", method= {RequestMethod.PUT, RequestMethod.GET})
		
		public String updateFilm(Film film) {
				
			filmService.updateFilm(film);
			return "redirect:/film/films";
			
		}
	*/	
	// handler method to handle delete film request
	
			@GetMapping("role/{roleId}")
			public String deleteRole(@PathVariable Long roleId) {
				//filmService.deleteFilmById(filmId);
				roleService.deleteById(roleId);
				return "redirect:/role";
			}
		//The assignRole
			@RequestMapping("role/assign/{userId}/{roleId}")
			public String assignRole(@PathVariable Long userId, 
			                         @PathVariable Long roleId){
				roleService.assingUserRole(userId, roleId);
			    
			    return "redirect:/user/Edit/"+userId;
			}
			
			//The unassignRole

			@RequestMapping("role/unassign/{userId}/{roleId}")
			public String unassignRole(@PathVariable Long userId,
			                           @PathVariable Long roleId){
				roleService.unassignUserRole(userId, roleId);
			    
			    return "redirect:/user/Edit/"+userId;
			}

			
}
