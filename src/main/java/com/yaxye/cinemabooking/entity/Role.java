package com.yaxye.cinemabooking.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
//role entity 

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	@Column(name ="role_name")
	private String roleName;
	
	public Role() {
		
	}

	public Role(long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
		
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(roleId, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return roleId == other.roleId && Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
}