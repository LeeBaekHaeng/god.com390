package god.test.a1.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import god.test.a1.service.A1VO;
import god.test.a1.service.GodTestA1Service;

@RestController
@RequestMapping("/api/v1/a1")
public class GodTestA1RestController {

	private final GodTestA1Service service;

	public GodTestA1RestController(GodTestA1Service service) {
		this.service = service;
	}

	@GetMapping
	public Map<String, Object> selectList(A1VO vo) {
		Map<String, Object> map = new HashMap<>();
		map.put("results", service.selectList(vo));
		return map;
	}

}
