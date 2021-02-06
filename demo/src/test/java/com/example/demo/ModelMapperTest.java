package com.example.demo;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ModelMapperTest {

	@Test
	void test() {
		Order order = Order.builder().customerName("customerName1").build();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

		log.debug("order: {}", order);
		log.debug("getCustomerName: {}", order.getCustomerName());

		log.debug("orderDTO: {}", orderDTO);
		log.debug("getCustomerName: {}", orderDTO.getCustomerName());
	}

	@Test
	void test2() {
		OrderDTO orderDTO = OrderDTO.builder().customerName("customerName1").build();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
		Order order = modelMapper.map(orderDTO, Order.class);

		log.debug("orderDTO: {}", orderDTO);
		log.debug("getCustomerName: {}", orderDTO.getCustomerName());

		log.debug("order: {}", order);
		log.debug("getCustomerName: {}", order.getCustomerName());

	}

}
