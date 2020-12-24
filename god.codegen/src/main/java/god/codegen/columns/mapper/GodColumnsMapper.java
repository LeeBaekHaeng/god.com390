package god.codegen.columns.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.columns.service.ColumnsVO;

@Mapper
public interface GodColumnsMapper {

	List<EgovMap> selectList(ColumnsVO vo);

}
