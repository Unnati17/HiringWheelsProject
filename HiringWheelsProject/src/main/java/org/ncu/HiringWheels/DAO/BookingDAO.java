package org.ncu.HiringWheels.DAO;

import org.ncu.HiringWheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDAO extends JpaRepository<Booking,Long> {

}
