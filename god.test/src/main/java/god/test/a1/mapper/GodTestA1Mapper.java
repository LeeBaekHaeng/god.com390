package god.test.a1.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface GodTestA1Mapper {

	List<EgovMap> selectList();

}
