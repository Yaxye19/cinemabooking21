package com.yaxye.cinemabooking.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@DynamicInsert
@Entity
@Table(name="users")
public class User implements UserDetails {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 146232847499014513L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	 @Column(name="firstName", length = 50, nullable= false)
	 @NotEmpty(message = "First Name cannot be empty")
	    private String firstName;
	   
	 	@Column(name="lastName", length = 50, nullable= false)
	 	@NotEmpty(message = "Last Name cannot be empty")
	    private String lastName;
		@Column(name="phone", length = 16, nullable= false)
		@NotEmpty(message = "Phone Number cannot be empty")
	    private String phone;
		@Column(name="password", length = 50, nullable= false)
		@NotEmpty(message = "Password cannot be empty")
	    private String password;
	    @Column(name="email", unique=true,
	    		length = 30, nullable= false,
				columnDefinition= "TEXT"
				)
	    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
		@NotEmpty(message = "Email cannot be empty")
	    private String email;
	    private String username;
	    @JsonManagedReference
	    @OneToMany(mappedBy = "user")
	    private Set<Ticket> tickets;

	    private int active = 1;
	    @JsonManagedReference
		  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		  
		  @JoinTable( name = "users_roles", joinColumns = @JoinColumn(name =
		  "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id") )
		  private Set<Role> roles = new HashSet<>();
		public User() {
			super();
		}
		public User(Long userId, String firstName, String lastName, String username,
				String phone, String password, String email,
				Set<Ticket> tickets, int active, Set<Role> roles) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.password = password;
			this.email = email;
			this.tickets = tickets;
			this.active = active;
			this.roles = roles;
			this.username = username;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Set<Ticket> getTickets() {
			return tickets;
		}
		public void setTickets(Set<Ticket> tickets) {
			this.tickets = tickets;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		public String getusername() {
			return username;
		}
		public void setusername(String username) {
			this.username = username;
		}
		@Override
		public int hashCode() {
			return Objects.hash(active, email, firstName, lastName, password, phone, roles, tickets, userId, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return active == other.active && Objects.equals(email, other.email)
					&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
					&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
					&& Objects.equals(roles, other.roles) && Objects.equals(tickets, other.tickets)
					&& Objects.equals(userId, other.userId) && Objects.equals(username, other.username);
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
					+ ", password=" + password + ", email=" + email + ", username=" + username + ", tickets=" + tickets
					+ ", active=" + active + ", roles=" + roles + "]";
		}
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Set<Role> roles = getRoles();
	        List<GrantedAuthority> authorities = new ArrayList<>();

	       
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
	        }
	        return authorities;
		}
		@Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return this.getActive() == 1;
	    }

		@Override
		public String getUsername() {
			
			return this.getEmail();
		}
		
		public void addRole(Role role) {
			this.roles.add(role);
		}
}