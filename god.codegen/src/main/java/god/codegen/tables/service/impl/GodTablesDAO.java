package god.codegen.tables.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.tables.mapper.GodTablesMapper;
import god.codegen.tables.service.TablesVO;

@Repository
public class GodTablesDAO {

	private final GodTablesMapper mapper;

	public GodTablesDAO(GodTablesMapper mapper) {
		this.mapper = mapper;
	}

	public List<EgovMap> selectList(TablesVO vo) {
		return mapper.selectList();
	}

}
