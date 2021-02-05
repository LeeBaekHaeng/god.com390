package god.test.menu.mapper;

import java.util.List;

import egovframework.com.sym.mnu.mcm.service.MenuSiteMapVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface MenuMapper {

	List<EgovMap> selectList(MenuSiteMapVO vo);

}
