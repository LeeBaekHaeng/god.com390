package com.example.demo.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.entity.EntrprsMber;

public class EntrprsMberSpecs {

	public static Specification<EntrprsMber> equalEntrprsMberId(EntrprsMber entity) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(entity.getEntrprsMberId())) {
				return builder.equal(root.get("entrprsMberId"), entity.getEntrprsMberId());
			} else {
				return null;
			}
		};
	}

	public static Specification<EntrprsMber> equalEntrprsSeCode(EntrprsMber entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getEntrprsSeCode())) {
				return criteriaBuilder.equal(root.get("entrprsSeCode"), entity.getEntrprsSeCode());
			} else {
				return null;
			}
		};
	}

	public static Specification<EntrprsMber> likeCmpnyNm(EntrprsMber entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getCmpnyNm())) {
				return criteriaBuilder.like(root.get("cmpnyNm"), entity.getCmpnyNm() + "%");
			} else {
				return null;
			}
		};
	}

	public static Specification<EntrprsMber> where(EntrprsMber entity) {
		return equalEntrprsMberId(entity).and(equalEntrprsSeCode(entity)).and(likeCmpnyNm(entity));
	}

}
