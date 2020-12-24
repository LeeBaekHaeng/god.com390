package god.codegen.tables.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import god.codegen.tables.service.GodTablesService;
import god.codegen.tables.service.TablesVO;

@Controller
public class GodTablesController {

	private final GodTablesService service;

	public GodTablesController(GodTablesService service) {
		this.service = service;
	}

	@RequestMapping("/tables/selectList.do")
	public String selectList(TablesVO vo, Model model) {
		service.selectList(vo, model);
		return "god/codegen/tables/selectList";
	}

}
