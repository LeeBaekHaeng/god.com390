package com.example.demo.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.entity.ComTnGnrlMber;

public class ComTnGnrlMberSpecs {

	public static Specification<ComTnGnrlMber> equalMberId(ComTnGnrlMber entity) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(entity.getMberId())) {
				return builder.equal(root.get("mberId"), entity.getMberId());
			} else {
				return null;
			}
		};
	}

	public static Specification<ComTnGnrlMber> equalPassword(ComTnGnrlMber entity) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.hasText(entity.getPassword())) {
				return criteriaBuilder.equal(root.get("password"), entity.getPassword());
			} else {
				return null;
			}
		};
	}

	public static Specification<ComTnGnrlMber> where(ComTnGnrlMber entity) {
		return equalMberId(entity).and(equalPassword(entity));
	}

}
