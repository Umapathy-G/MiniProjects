package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "*Name required")
	private String name;

	@NotEmpty(message = "*Email required")
	@Email(message = "*Invalid email")
	private String email;

	@NotNull(message = "*Phone No required")
	private Long phone;

	@NotNull(message = "*Gender required")
	private String gender;

	@NotNull(message = "*DOB required")
	private LocalDate dob;

	@NotNull(message = "*SSN required")
	private Long ssn;

	private String active = "Y";

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdate;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updatedate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public LocalDateTime getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}

	public LocalDateTime getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDateTime updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender="
				+ gender + ", dob=" + dob + ", ssn=" + ssn + ", active=" + active + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + "]";
	}

}