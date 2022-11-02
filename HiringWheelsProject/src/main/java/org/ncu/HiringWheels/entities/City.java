package org.ncu.HiringWheels.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="city")
public class City {

	@Id @Column(name="city_id") @Range(max=10)
	private long id;
	
	@Column(name="city_name",nullable=false) @NotNull
	private String name;
	
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	Set<Location> locations = new HashSet<Location>();
	
	public City() {
		
	}
	
	public City(long id) {
		this.id = id;
	}
	
	public City(@NotNull String name) {
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

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", locations=" + locations + "]";
	}

	
}
