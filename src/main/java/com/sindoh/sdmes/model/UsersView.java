package com.sindoh.sdmes.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users_v")
public class UsersView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	private String username;
	private String name;
	private String email;
	private String organization;
	private Long site;
	private Long role_id;
	private String role_name;
	private String lang;
	private String firstname;
	private String lastname;
	
	@Column(name="registered_date")
	private Date registeredDate;
	
	@Column(name="disable_date")
	private Date disableDate;

	public UsersView(Long id) {
		this.id = id;
	}
	
	public UsersView() {
		
	}
}
