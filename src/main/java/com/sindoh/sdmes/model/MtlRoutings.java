package com.sindoh.sdmes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mtl_routings")
public class MtlRoutings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="routing_id")
	private Long id;
	
	@Column(name="assy_item_id")
	private Integer itemid;
	
	@Column(name="assy_item_number")
	private String item;
	
	private LocalDateTime creation_date = LocalDateTime.now();
	private LocalDateTime last_update_date = LocalDateTime.now();
	private Integer created_by;
	private Integer last_updated_by;
	
	@Column(name="routing_desc")
	private String desc;
	
	@Column(name="mfg_site_id")
	private Integer site;
	
	public MtlRoutings(Long id) {
		this.id = id;
	}

	public MtlRoutings() {
		
	}
	
}
