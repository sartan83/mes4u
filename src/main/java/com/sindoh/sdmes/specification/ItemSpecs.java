package com.sindoh.sdmes.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sindoh.sdmes.model.MtlItemMastersView;

public class ItemSpecs {
	public static Specification<MtlItemMastersView> searchWith(Map<String, Object> params) {
		return (Specification<MtlItemMastersView>) ((root, query, builder) -> {
			List<Predicate> predicate = getPredicateWithKeyword(params, root, builder);
			return builder.and(predicate.toArray(new Predicate[0]));
		});
	}
	
	public static List<Predicate> getPredicateWithKeyword(Map<String, Object> params, Root<MtlItemMastersView> root, CriteriaBuilder builder) {
		
		List<Predicate> predicate = new ArrayList<>();
		
		System.out.println(params.toString());
		
		if (params.get("item_number") != null && !params.get("item_number").equals("")) {
			predicate.add(builder.like(root.get("item_number"), "%"+(String)params.get("item_number")+"%"));
		}
		
		if (params.get("product_family") != null && !params.get("product_family").equals("")) {
			predicate.add(builder.like(root.get("product_family"), "%"+(String)params.get("product_family")+"%"));
		}
		
		return predicate;		
	}
	
}
