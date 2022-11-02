package org.ncu.HiringWheels.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=User.class)
public class User {
	
	@Id @Column(name="user_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Range(max=10)
	private long id;
	
	@Column(name="first_name",nullable=false) @NotNull
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="password",nullable=false) @NotNull @Size(min=5)
	private String password;
	
	@Column(name="email",nullable=false,unique=true) @NotNull @Email
	private String emailID;
	
	@Column(name="mobile_no",nullable=false,unique=true) @Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	
	@ManyToOne()
	@JoinColumn(name="role_id")
	@JsonIdentityReference(alwaysAsId = true)
	private Role role;
	
	@Column(name="wallet_money",columnDefinition="DECIMAL(10,2) default 100000.00")
	private double walletMoney;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Booking> bookings = new HashSet<>();
	
	public User() {
		
	}
	
	public User(@NotNull String firstName, String lastName, @NotNull @Min(5) String password, @NotNull @Email String emailID,
			@Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber, Role role, double walletMoney) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailID = emailID;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.walletMoney = walletMoney;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public double getWalletMoney() {
		return walletMoney;
	}

	public void setWalletMoney(double walletMoney) {
		this.walletMoney = walletMoney;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", emailID=" + emailID + ", mobileNumber=" + mobileNumber + ", roleId =" + role.getId() + ", walletMoney="
				+ walletMoney + ", bookings=" + bookings + "]";
	}
	
}

