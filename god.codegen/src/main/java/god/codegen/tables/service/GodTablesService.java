package god.codegen.tables.service;

import java.util.List;

import org.springframework.ui.Model;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface GodTablesService {

	List<EgovMap> selectList(TablesVO vo);

	void selectList(TablesVO vo, Model model);

}
