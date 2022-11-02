package org.ncu.HiringWheels.srvcs;

import org.ncu.HiringWheels.entities.User;

public interface UserService {

	public boolean signUp(User user);
	
	public User signIn(String emailID,String password);
}
