package org.ncu.HiringWheels.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ncu.HiringWheels.DAO.VehicleDAO;
import org.ncu.HiringWheels.entities.Booking;
import org.ncu.HiringWheels.entities.Vehicle;
import org.ncu.HiringWheels.entities.VehicleSubCategory;
import org.ncu.HiringWheels.srvcs.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleDAO vehicleDAO;
	
	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleDAO.findAll();
	}

	@Override
	public List<Vehicle> getAvailableVehicles(VehicleSubCategory vehicleSubCategory, Booking bookingDetails) {
		List<Vehicle> availableVehicles = new ArrayList<>();
		vehicleDAO.findAll().forEach(vehicle -> {
			Vehicle v = vehicle;
			if(v.getAvailabilityStatus() == 1 && v.getSubcategory().getId() == vehicleSubCategory.getId()
					&& v.getLocation().getCity() == bookingDetails.getLocation().getCity() && 
						isBooked(v.getBookings(),bookingDetails)
					) {
				availableVehicles.add(vehicle);
			}
		}
		);
		return availableVehicles;	
	}
	
	public boolean isBooked(Set<Booking> bookings,Booking userQuery) {
		for(Booking booking : bookings) {
			if(userQuery.getPickUpDate().after(booking.getPickUpDate()) && userQuery.getDropOffDate().before(booking.getDropOffDate())) {
				return false;
			}
		}
		return true;
	}

	
}
