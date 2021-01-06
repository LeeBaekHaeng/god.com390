package god.test.a1.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import god.test.a1.service.A1VO;
import god.test.a1.service.GodTestA1Service;

@Service
public class GodTestA1ServiceImpl extends EgovAbstractServiceImpl implements GodTestA1Service {

	private final GodTestA1DAO dao;

	private final EgovIdGnrService egovMailMsgIdGnrService;

	public GodTestA1ServiceImpl(GodTestA1DAO dao, EgovIdGnrService egovMailMsgIdGnrService) {
		this.dao = dao;
		this.egovMailMsgIdGnrService = egovMailMsgIdGnrService;
	}

	@Override
	public void selectList(A1VO vo, Model model) {
		if (vo.getTableSchema() == null) {
			vo.setTableSchema("com");
		}
		model.addAttribute("tables", dao.selectList(vo));
		try {
			model.addAttribute("mailMsgId", egovMailMsgIdGnrService.getNextStringId());
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
		}
	}

	@Override
	public void selectList2(A1VO vo, Model model) {
		if (vo.getTableSchema() == null) {
			vo.setTableSchema("com");
		}
		model.addAttribute("tables", dao.selectList2(vo));
		try {
			model.addAttribute("mailMsgId", egovMailMsgIdGnrService.getNextStringId());
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
		}
	}

	@Override
	@CacheEvict(value = "testCache", allEntries = true)
	public void deleteCacheEvict(A1VO vo, Model model) {
	}

}
