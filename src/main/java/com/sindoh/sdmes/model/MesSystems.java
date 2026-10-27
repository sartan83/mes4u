package com.sindoh.sdmes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mes_systems")
public class MesSystems {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
	private Long id;
	
	private String name;
	private String type;
	private String description;
	
	@Column(name="call_type")
	private String calltype;
	
	@Column(name="call_value")
	private String callvalue;

	@Column(name="call_proc")
	private String callproc;

	@Column(name="default_flag")
	private String defaultflag = "N";
	
	@Column(name = "creation_date")
	private LocalDateTime creationdate = LocalDateTime.now();
	
	@Column(name = "created_by")
	private Long createdby;
	
	@Column(name = "last_update_date")
	private LocalDateTime lastupdatedate = LocalDateTime.now();

	@Column(name = "last_updated_by")
	private Long lastupdatedby;
	
	@Column(name="disable_date")
	private LocalDateTime disabledate;
	
	public MesSystems(Long id) {
		this.id = id;
	}

	public MesSystems() {
		
	}
	
}
