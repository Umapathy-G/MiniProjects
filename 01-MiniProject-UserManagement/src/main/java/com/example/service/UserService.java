package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.UserAccount;

@Service
public interface UserService {

	public String saveOrUpdateUserAcc(UserAccount userAcc);

	public List<UserAccount> getAllUserAccounts();

	public UserAccount getUserAcc(Integer userId);

	public boolean deleteUserAcc(Integer userId);

	public void updateUserAccStatus(Integer userId, String status);
	
	default void userList() {
		System.out.println("Helllo ");
	}
	
}
