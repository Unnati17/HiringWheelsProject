package org.ncu.HiringWheels.DAO;

import org.ncu.HiringWheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleDAO extends JpaRepository<Vehicle,Long> {
	
}
