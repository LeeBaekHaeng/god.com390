package god.codegen.columns.service;

import java.util.List;

import org.springframework.ui.Model;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface GodColumnsService {

	List<EgovMap> selectList(ColumnsVO vo);

	void selectList(ColumnsVO vo, Model model);

}
