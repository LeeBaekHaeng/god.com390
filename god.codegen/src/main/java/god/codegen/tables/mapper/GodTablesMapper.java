package god.codegen.tables.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.tables.service.TablesVO;

@Mapper
public interface GodTablesMapper {

	List<EgovMap> selectList(TablesVO vo);

}
