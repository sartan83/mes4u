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
@Table(name="mes_printing_programs")
public class MesPrintingPrograms {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
	private Long id;


	@Column(name="system_id")
	private Long systemid;
	
	private String type;
	private String name;
	private String file;
	private String description;
	private String parameters;
	private String labels;
	private String attributes;
	private String contents;
	private String qrcode;

	@Column(name="used_operation")
	private String usedoperation;
	
	@Column(name="order_flag")
	private String orderflag;
	
	@Column(name="serial_flag")
	private String serialflag;

	@Column(name = "creation_date")
	private LocalDateTime creationdate = LocalDateTime.now();
	
	@Column(name = "created_by")
	private Long createdby;
	
	@Column(name = "last_update_date")
	private LocalDateTime lastupdatedate = LocalDateTime.now();

	@Column(name = "last_updated_by")
	private Long lastupdatedby;
	
	public MesPrintingPrograms(Long id) {
		this.id = id;
	}

	public MesPrintingPrograms() {
		
	}
	
}
