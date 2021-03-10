package com.example.demo.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.entity.EmplyrInfo;

public class EmplyrInfoSpecs {

	public static Specification<EmplyrInfo> equalEmplyrId(EmplyrInfo entity) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(entity.getEmplyrId())) {
				return builder.equal(root.get("emplyrId"), entity.getEmplyrId());
			} else {
				return null;
			}
		};
	}

	public static Specification<EmplyrInfo> equalOrgnztId(EmplyrInfo entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getOrgnztId())) {
				return criteriaBuilder.equal(root.get("orgnztId"), entity.getOrgnztId());
			} else {
				return null;
			}
		};
	}

	public static Specification<EmplyrInfo> likeUserNm(EmplyrInfo entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getUserNm())) {
				return criteriaBuilder.like(root.get("userNm"), entity.getUserNm() + "%");
			} else {
				return null;
			}
		};
	}

	public static Specification<EmplyrInfo> where(EmplyrInfo entity) {
		return equalEmplyrId(entity).and(equalOrgnztId(entity)).and(likeUserNm(entity));
	}

}
