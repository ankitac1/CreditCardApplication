package com.cg.service;

import com.cg.entity.User;

public interface IUserService {

	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(User user);
}
