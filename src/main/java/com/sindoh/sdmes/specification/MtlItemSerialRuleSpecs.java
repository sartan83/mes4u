package com.sindoh.sdmes.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sindoh.sdmes.model.MtlItemSerialRules;

public class MtlItemSerialRuleSpecs {
	public static Specification<MtlItemSerialRules> searchWith(Map<String, Object> params) {
		return (Specification<MtlItemSerialRules>) ((root, query, builder) -> {
			List<Predicate> predicate = getPredicateWithKeyword(params, root, builder);
			return builder.and(predicate.toArray(new Predicate[0]));
		});
	}
	
	public static List<Predicate> getPredicateWithKeyword(Map<String, Object> params, Root<MtlItemSerialRules> root, CriteriaBuilder builder) {
		List<Predicate> predicate = new ArrayList<>();
		
		if (params.get("desc") != null && !params.get("desc").equals("")) {
			predicate.add(builder.like(root.get("serialRuleDescription"), "%"+(String)params.get("desc")+"%"));
		}
		
		if (params.get("monthtype") != null && !params.get("monthtype").equals("")) {
			predicate.add(builder.like(root.get("prefixYearMonthType"), "%"+(String)params.get("monthtype")+"%"));
		}
		
		return predicate;		
	}
}
