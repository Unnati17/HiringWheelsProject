package org.ncu.HiringWheels.srvcs;

import java.util.List;

import org.ncu.HiringWheels.entities.Booking;
import org.ncu.HiringWheels.entities.Vehicle;
import org.ncu.HiringWheels.entities.VehicleSubCategory;

public interface VehicleService {

	public List<Vehicle> getAllVehicles();
	
	public List<Vehicle> getAvailableVehicles(VehicleSubCategory vehicleCategory,Booking bookingDetails);
}
