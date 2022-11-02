package org.ncu.HiringWheels.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="location")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=Location.class)
public class Location {

	@Id @Column(name="location_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Range(max=10)
	private long id;
	
	@Column(name="location_name",nullable=false) @NotNull
	private String name;
	
	@Column(name="address",nullable=false) @NotNull
	private String address;
	
	@ManyToOne
	private City city;
	
	@Column(name="pincode",nullable=false) @NotNull @Pattern(regexp="(^$|[0-9]{6})")
	private String pincode;
	
	@OneToMany(mappedBy="location",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Vehicle> vehicles = new HashSet<>();
	
	@OneToMany(mappedBy="location",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Booking> bookings = new HashSet<>();
	
	public Location() {
		
	}
	
	public Location(long id) {
		this.id = id;
	}

	public Location(@NotNull String name, @NotNull String address,
			@NotNull @Pattern(regexp = "(^$|[0-9]{6})") String pincode) {
		this.name = name;
		this.address = address;
		this.pincode = pincode;
	}

	public long getId() {
		return id;
	}
	
	public String getGeneratedId() {
		return Long.toString(id);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", vehicles=" + vehicles + ", bookings=" + bookings + "]";
	}
	
}