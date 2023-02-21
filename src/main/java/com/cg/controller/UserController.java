package com.cg.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Impl.UserService;
import com.cg.entity.User;


@RestController
@RequestMapping("/loginapi")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {}
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/adduser")
	public String register(@Valid @RequestBody User user) {
		return userService.register(user);
	}
	
	@GetMapping("/getallusers")
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	
	@DeleteMapping("/deleteuser")
	public void deleteU(@RequestBody User user) {
		userService.deleteUser(user);
		System.out.println("Successfully deleted");
	}
	
	@PostMapping("/signin")
	public User signIn(@Valid @RequestBody User user) {
		return userService.signIn(user);
	}
	
	@GetMapping("/signout")
	public User signOut(@RequestBody User user) {
		return userService.signOut(user);
	}
	
	@PutMapping("/changepassword")
	public User changePassword(@Valid @RequestBody User user) {
		return userService.changePassword(user);
	}
}
