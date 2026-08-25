package com.sindoh.sdmes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mes_sites")
public class MesSites {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String country;
	
	@Column(length = 100)
	private String location;
	
	@Column(length = 100, name="site_name")
	private String name;
	
	public MesSites(Long id) {
		this.id = id;
	}
	
	public MesSites() {
		
	}
	
}
