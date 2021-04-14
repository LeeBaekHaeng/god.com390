package egovframework.com.cmm.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class GodCorsFilter extends CorsFilter {

	public GodCorsFilter() {
		super(configurationSource());
	}

	private static UrlBasedCorsConfigurationSource configurationSource() {
		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("http://domain1.com");
		List<String> allowedOrigins = new ArrayList<>();
		allowedOrigins.add("http://domain1.com");
		allowedOrigins.add("http://domain2.com");
		allowedOrigins.add("http://localhost:8180");
		config.setAllowedOrigins(allowedOrigins);
		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/api/**", config);
		return source;
	}

}
