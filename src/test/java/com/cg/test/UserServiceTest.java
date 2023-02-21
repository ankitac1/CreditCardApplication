package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.Impl.UserService;
import com.cg.entity.User;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.repository.IUserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	private IUserRepository userRepository;
	@InjectMocks
	private UserService userService;
	
	private User user;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User(1L ,"Pass@4749");
	}

	@Test
	void testRegister() {
		when(userRepository.saveAndFlush(user)).thenReturn(user);
		String result = userService.register(user);
		assertEquals("New User Added Successfully",result);
		verify(userRepository,times(1)).saveAndFlush(user);
	}

	@Test
	void testGetAllUsers() {
		List<User> users = Collections.singletonList(user);
		when(userRepository.findAll()).thenReturn(users);
		List<User> result = userService.getAllUsers();
		assertEquals(users,result);
		verify(userRepository,times(1)).findAll();
	}

	@Test
	void testDeleteUser() {
		userService.deleteUser(user);
		verify(userRepository,times(1)).delete(user);
	}

	@Test
	void testSignIn() {
		when(userRepository.existsById(user.getUserId())).thenReturn(true);
		when(userRepository.findById(user.getUserId())).thenReturn(java.util.Optional.of(user));
		User result = userService.signIn(user);
		assertEquals(user,result);
		verify(userRepository, times(1)).existsById(user.getUserId());
		verify(userRepository, times(1)).findById(user.getUserId());
	}
}
