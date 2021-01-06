package god.test.a1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import god.test.a1.service.A1VO;
import god.test.a1.service.GodTestA1Service;

@Controller
public class GodTestA1Controller {

	private final GodTestA1Service service;

	public GodTestA1Controller(GodTestA1Service service) {
		this.service = service;
	}

	@RequestMapping("/a1/selectList.do")
	public String selectList(A1VO vo, Model model) {
		service.selectList(vo, model);
		return "god/test/a1/selectList";
	}

	@RequestMapping("/a1/selectList2.do")
	public String selectList2(A1VO vo, Model model) {
		service.selectList2(vo, model);
		return "god/test/a1/selectList";
	}

	@RequestMapping("/a1/deleteCacheEvict.do")
	public String deleteCacheEvict(A1VO vo, Model model) {
		service.deleteCacheEvict(vo, model);
		return "god/test/a1/selectList";
	}

}
