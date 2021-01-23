package com.example.demo;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		User user = new User();
		user.setName("test god");
		return Optional.of(user.getName());
	}

}
