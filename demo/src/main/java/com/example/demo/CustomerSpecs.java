package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CustomerSpecs {
	public static Specification<Customer> isLongTermCustomer(Customer customer) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(customer.getFirstName())) {
				return builder.like(root.get("firstName"), customer.getFirstName() + "%");
			}

			return null;
		};
	}

	public static Specification<Customer> hasSalesOfMoreThan(Customer customer) {
		return (root, query, builder) -> {
			if (StringUtils.hasText(customer.getLastName())) {
				return builder.equal(root.get("lastName"), customer.getLastName());
			}

			return null;
		};
	}

	public static Specification<Customer> spec(Customer customer) {
		return (root, query, builder) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.hasText(customer.getFirstName())) {
				predicates.add(builder.like(root.get("firstName"), customer.getFirstName() + "%"));
			}

			if (StringUtils.hasText(customer.getLastName())) {
				predicates.add(builder.equal(root.get("lastName"), customer.getLastName()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Customer> spec2(Customer customer) {
		return (root, query, builder) -> {

			List<Predicate> restrictions = new ArrayList<>();

			if (StringUtils.hasLength(customer.getFirstName())) {
				restrictions.add(builder.like(root.get("firstName"), customer.getFirstName() + "%"));
			}

			if (StringUtils.hasLength(customer.getLastName())) {
				restrictions.add(builder.equal(root.get("lastName"), customer.getLastName()));
			}

			return builder.and(restrictions.toArray(new Predicate[0]));
		};
	}

}
