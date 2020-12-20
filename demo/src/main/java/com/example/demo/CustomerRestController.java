package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	private final CustomerRepository repository;

	@Autowired
	public CustomerRestController(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Customer> findAll(Customer customer) {
		return repository.findAll(CustomerSpecs.spec2(customer));
	}

	@GetMapping("/{id}/search/test1")
	public Map<String, Object> searchTest1(@PathVariable("id") Long id, Customer customer) {
		Map<String, Object> map = new HashMap<>();

		map.put("id", id);
		map.put("customer", customer);
		map.put("test1", "test1");

		return map;
	}

	@GetMapping("/{id}/search/test2")
	public Map<String, Object> searchTest2(@PathVariable("id") Long id, Customer customer) {
		Map<String, Object> map = new HashMap<>();

		map.put("id", id);
		map.put("customer", customer);
		map.put("test2", "test2");

		return map;
	}

	@GetMapping("/{id}")
	public Customer getOne(@PathVariable("id") Long id) {
		return repository.getOne(id);
	}

}
