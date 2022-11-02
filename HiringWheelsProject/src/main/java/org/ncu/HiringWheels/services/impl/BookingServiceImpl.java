package org.ncu.HiringWheels.services.impl;

import org.ncu.HiringWheels.DAO.BookingDAO;
import org.ncu.HiringWheels.DAO.UserDAO;
import org.ncu.HiringWheels.entities.Booking;
import org.ncu.HiringWheels.entities.User;
import org.ncu.HiringWheels.srvcs.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public Booking addBooking(Booking bookingDetails) {
		User user = userDAO.getReferenceById(bookingDetails.getUser().getId());
		if(bookingDetails.getAmount() > user.getWalletMoney()) {
			return null;
		}
		else {
			double balanceInWallet = user.getWalletMoney() - bookingDetails.getAmount();
			user.setWalletMoney(balanceInWallet);
			userDAO.save(user);
			return bookingDAO.save(bookingDetails);
		}
	}
	
								
}
