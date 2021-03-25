package com.example.demo.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.entity.CmmnClCode;

public class CmmnClCodeSpecs {

	public static Specification<CmmnClCode> equalClCode(CmmnClCode entity) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(entity.getClCode())) {
				return builder.equal(root.get("clCode"), entity.getClCode());
			} else {
				return null;
			}
		};
	}

	public static Specification<CmmnClCode> likeClCodeNm(CmmnClCode entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getClCodeNm())) {
				return criteriaBuilder.like(root.get("clCodeNm"), "%" + entity.getClCodeNm() + "%");
			} else {
				return null;
			}
		};
	}

	public static Specification<CmmnClCode> where(CmmnClCode entity) {
		return equalClCode(entity).and(likeClCodeNm(entity));
	}

}
