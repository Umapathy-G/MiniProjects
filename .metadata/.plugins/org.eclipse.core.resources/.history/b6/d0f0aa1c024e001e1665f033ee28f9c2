package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.UserAccount;

import jakarta.transaction.Transactional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Modifying
	@Transactional
	@Query("update UserAccount set active=:status where id=:userId ")
	public void updateUserAccStatus(Integer userId, String status);
}
