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
@Table(name="vehicle_subcategory")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=VehicleSubCategory.class)
public class VehicleSubCategory {

	@Id @Column(name="vehicle_subcategory_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Range(max=10)
	private long id;
	
	@Column(name="vehicle_subcategory_name",nullable=false,unique=true) @NotNull
	private String name;
	
	@Column(name="price_per_day",nullable=false) @NotNull
	private double pricePerDay;
	
	@OneToMany(mappedBy="subcategory",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Vehicle> vehicles = new HashSet<>();
	
	@ManyToOne
	private VehicleCategory category;
	
	public VehicleSubCategory() {
		
	}
	
	public VehicleSubCategory(long id) {
		this.id = id;
	}
	
	public VehicleSubCategory(@NotNull String name, @NotNull double pricePerDay) {
		this.name = name;
		this.pricePerDay = pricePerDay;
	}
	
	public VehicleSubCategory(@NotNull String name, @NotNull double pricePerDay, VehicleCategory category) {
		this.name = name;
		this.pricePerDay = pricePerDay;
		this.category = category;
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

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public VehicleCategory getCategory() {
		return category;
	}

	public void setCategory(VehicleCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "VehicleSubCategory [id=" + id + ", name=" + name + ", pricePerDay=" + pricePerDay + ", vehicles="
				+ vehicles + ", category=" + category + "]";
	}
	
	
	
}