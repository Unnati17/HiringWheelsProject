package org.ncu.HiringWheels.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="fuel_type")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=FuelType.class)
public class FuelType {

	@Id @Column(name="fuel_type_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Range(max=10)
	private long id;
	
	@Column(name="fuel_type",nullable=false,unique=true) @NotNull
	private String type;
	
	@OneToMany(mappedBy="fuelType",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Vehicle> vehicles = new HashSet<>();
	
	public FuelType() {
		
	}
	
	public FuelType(long id) {
		this.id = id;
	}

	public FuelType(@NotNull String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FuelType [id=" + id + ", type=" + type + "]";
	}
	
}
