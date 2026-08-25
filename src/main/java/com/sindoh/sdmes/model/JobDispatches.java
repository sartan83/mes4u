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
@Table(name="job_dispatches")
public class JobDispatches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dispatch_id")
	private Long id;
	
	@Column(name="item_number")
	private String item;
	
	@Column(name="line_name")
	private String line;
	
	@Column(name="interfaced_wo_num")
	private String wo;
	
	@Column(name="product_family")
	private String family;
	
	@Column(name="serial_check")
	private String serialcheck;
	
	@Column(name="line_id")
	private Long lineid;
	
	private String status;
	private Integer item_id;
	private Integer qty;
	private Date start_date;
	private Date creation_date;

	@Column(name = "mfg_site_id")
	private Integer site;
	
	private Date fixed_manufacturing_date;
	
	public JobDispatches(Long id) {
		this.id = id;
	}

	public JobDispatches() {
		
	}
	
}
