package org.ncu.HiringWheels.srvcs;

import org.ncu.HiringWheels.entities.Vehicle;

public interface AdminService {

	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle changeAvailability(long vehicleID,int status);
}

