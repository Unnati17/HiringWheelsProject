package org.ncu.HiringWheels.DAO;

import org.ncu.HiringWheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User,Long>{

	
	@Query("SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(?1)")
	User findByFirstName(String firstName);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(?1) OR "
			+ "LOWER(u.lastName) = LOWER(?2)")
	User findByFirstOrLastName(String firstName,String lastName);

	@Query("SELECT u FROM User u WHERE LOWER(u.emailID) = LOWER(?1)")
	User findByEmailID(String emailID);

	@Query("SELECT u FROM User u WHERE LOWER(u.mobileNumber) = LOWER(?1)")
	User findByMobileNumber(String mobNumber);
	
}