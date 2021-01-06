package god.test.a1.service;

import org.springframework.ui.Model;

public interface GodTestA1Service {

	void selectList(A1VO vo, Model model);

	void selectList2(A1VO vo, Model model);

	void deleteCacheEvict(A1VO vo, Model model);

}
