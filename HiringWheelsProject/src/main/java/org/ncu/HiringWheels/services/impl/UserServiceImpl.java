package org.ncu.HiringWheels.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.ncu.HiringWheels.DAO.RoleDAO;
import org.ncu.HiringWheels.DAO.UserDAO;
import org.ncu.HiringWheels.entities.Role;
import org.ncu.HiringWheels.entities.User;
import org.ncu.HiringWheels.exceptions.UnAuthorizedUserException;
import org.ncu.HiringWheels.exceptions.UserNotFoundException;
import org.ncu.HiringWheels.srvcs.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userRepository;
	
	@Autowired
	private RoleDAO roleRepository;

	@Override
	public boolean signUp(User user) {
		Role role = roleRepository.getRoleByName(user.getRole().getName());
		if(role != null) {
			role.getUsers().add(user);
			roleRepository.flush();
		}
		else {
			Role newRole = new Role(user.getRole().getName().toUpperCase());
			Set<User> users = new HashSet<>();
			users.add(user);
			newRole.setUsers(users);
			if(roleRepository.save(newRole)==null) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public User signIn(String emailID,String password) {
		User user = userRepository.findByEmailID(emailID);
		if(user != null){
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				throw new UnAuthorizedUserException("Unauthorized User : "+emailID);
			}
		}
		else {
			throw new UserNotFoundException("User not found with "+emailID);
		}
	}
	
}
