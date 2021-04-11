package com.example.demo.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.entity.CmmnCode;

public class CmmnCodeSpecs {

	public static Specification<CmmnCode> equalCodeId(CmmnCode entity) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(entity.getCodeId())) {
				return builder.equal(root.get("codeId"), entity.getCodeId());
			} else {
				return null;
			}
		};
	}

	public static Specification<CmmnCode> likeCodeIdNm(CmmnCode entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getCodeIdNm())) {
				return criteriaBuilder.like(root.get("codeIdNm"), "%" + entity.getCodeIdNm() + "%");
			} else {
				return null;
			}
		};
	}

	public static Specification<CmmnCode> where(CmmnCode entity) {
		return equalCodeId(entity).and(likeCodeIdNm(entity));
	}

}
