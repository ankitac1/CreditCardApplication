package com.cg.Impl;

import java.util.List;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.User;
import com.cg.exceptions.PasswordNotFoundException;
import com.cg.exceptions.UserIdNotFoundException;
import com.cg.repository.IUserRepository;
import com.cg.service.IUserService;

@Service
public class UserService implements IUserService 
{

	@Autowired
	IUserRepository userRepository;
	private boolean s = false;

	public UserService() {
	}

	public UserService(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public String register(User user) {
		if (s == false) {

			String passwordregex = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z]).{8,}$";
			if (user.getPassword().matches(passwordregex)) {
				userRepository.saveAndFlush(user);
				return "New User Added Successfully";
			} else
				return "Password not according to rules";
		} else {
			return "Try Registering after signing out";
		}
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User signIn(User user) {
		if (s == false) {
			if (userRepository.existsById(user.getUserId())) {
				User uuser = userRepository.findById(user.getUserId()).get();
				String cpass = uuser.getPassword();
				if ((user.getPassword()).equals(cpass)) {
					System.out.println("Welcome! You have successfully signed in.");
					s = true;
				} else
					throw new PasswordNotFoundException("Password is wrong");
			} else
				throw new UserIdNotFoundException("This UserId doesn't exists");
		} else
			System.out.println("You are already signed in");
		return user;
	}

	@Override
	public User signOut(User user) {
		if (s == false) {
			System.out.println("Sign in into your account");
		} else {
			System.out.println("Signed out from your account");
			s = false;
		}
		return user;
	}

	@Override
	public User changePassword(User user) {
		
		User u = null;
		if(userRepository.existsById(user.getUserId())) {
			Scanner sc = new Scanner(System.in);
			User uuser = userRepository.findById(user.getUserId()).get();
			String oldpassword = uuser.getPassword();
			if((user.getPassword()).equals(oldpassword)) {
				s = true;
		System.out.println("Enter new password with minimum number of characters 8, Atleast one number, one symbol and one uppercase character");
		String newpassword = sc.next();
		sc.close();
		String passwordregex = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z]).{8,}$";
		if(newpassword.matches(passwordregex)) {
			u = new User(user.getUserId(),newpassword);
			userRepository.saveAndFlush(u);
			System.out.println("Password set");
		} else {
			u = new User(user.getUserId(),oldpassword);
			System.out.println("Try with another password");
		}
			} else {
				System.out.println("Wrong password entered. Can't change password");
			}
		} else {
			throw new UserIdNotFoundException("This UserId doesn't exists");
		}
		return u;
	}
}
