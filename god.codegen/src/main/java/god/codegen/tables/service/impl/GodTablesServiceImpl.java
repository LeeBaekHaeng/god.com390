package god.codegen.tables.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.tables.service.GodTablesService;
import god.codegen.tables.service.TablesVO;

@Service
public class GodTablesServiceImpl extends EgovAbstractServiceImpl implements GodTablesService {

	private final GodTablesDAO dao;

	public GodTablesServiceImpl(GodTablesDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EgovMap> selectList(TablesVO vo) {
		return dao.selectList(vo);
	}

	@Override
	public void selectList(TablesVO vo, Model model) {
		model.addAttribute("tables", dao.selectList(vo));
	}

}
