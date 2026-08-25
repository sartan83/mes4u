package com.sindoh.sdmes.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String organization;
	private Long site;
	private String lang;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate;
	
	@Column(name="last_update_date")
	private LocalDateTime lastUpdateDate;
	
	@Column(name="registered_date")
	private LocalDateTime registeredDate;
	
	@Column(name="disable_date")
	private LocalDateTime disableDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
    	joinColumns = @JoinColumn(name="user_id"),
    	inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Roles> roles = new HashSet<>();
	
	public Users(Long id) {
		this.id = id;
	}
	
	public Users() {
		
	}
	
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
