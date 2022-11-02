package org.ncu.HiringWheels.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="role")
public class Role {

	@Id @Column(name="role_id") @Range(max=10)
	private long id;
	
	@Column(name="role_name",nullable=false,unique=true) @NotNull
	private String name;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	
	public Role() {
		
	}
	
	public Role(long id) {
		this.id = id;
	}
	
	public Role(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name +" ]";
	}
	
}
