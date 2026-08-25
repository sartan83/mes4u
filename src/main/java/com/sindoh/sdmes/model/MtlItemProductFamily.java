package com.sindoh.sdmes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mtl_item_masters")
public class MtlItemProductFamily {
	@Id
	@Column(name="product_family")
	private String family;
	
	public MtlItemProductFamily(String family) {
		this.family = family;
	}

	public MtlItemProductFamily() {
		
	}
	
}
