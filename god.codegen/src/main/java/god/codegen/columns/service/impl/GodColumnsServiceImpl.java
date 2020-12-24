package god.codegen.columns.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.columns.service.ColumnsVO;
import god.codegen.columns.service.GodColumnsService;

@Service
public class GodColumnsServiceImpl extends EgovAbstractServiceImpl implements GodColumnsService {

	private final GodColumnsDAO dao;

	public GodColumnsServiceImpl(GodColumnsDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EgovMap> selectList(ColumnsVO vo) {
		return dao.selectList(vo);
	}

	@Override
	public void selectList(ColumnsVO vo, Model model) {
		model.addAttribute("Columns", dao.selectList(vo));
	}

}
