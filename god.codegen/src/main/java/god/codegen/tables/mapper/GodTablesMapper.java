package god.codegen.tables.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface GodTablesMapper {

	List<EgovMap> selectList();

}
