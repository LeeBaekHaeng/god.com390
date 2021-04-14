package god.test.a1.service;

import java.util.List;

import org.springframework.ui.Model;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface GodTestA1Service {

	void selectList(A1VO vo, Model model);

	List<EgovMap> selectList(A1VO vo);

	void selectList2(A1VO vo, Model model);

	void deleteCacheEvict(A1VO vo, Model model);

}
