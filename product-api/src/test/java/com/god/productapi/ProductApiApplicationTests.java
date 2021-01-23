package com.god.productapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.god.productapi.entity.Product;
import com.god.productapi.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles({ "mysql" })
class ProductApiApplicationTests {

	@Autowired
	private ProductRepository repository;

	@Test
	void contextLoads() {
		log.debug("test god");

		Product product = new Product();
//		product.setId(1L);
		product.setDisplayProductName("test 노출상품명");
		product.setSalePrice(10000D);

		log.debug("product: {}", product);

		Product save = repository.save(product);

		log.debug("save: {}", save);

		Product findById = repository.findById(save.getId()).get();

		log.debug("findById: {}", findById);
		log.debug("getId: {}", findById.getId());
		log.debug("getDisplayProductName: {}", findById.getDisplayProductName());
		log.debug("getSalePrice: {}", findById.getSalePrice());
	}

}
