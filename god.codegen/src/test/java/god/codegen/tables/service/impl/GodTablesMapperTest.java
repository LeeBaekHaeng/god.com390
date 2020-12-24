package god.codegen.tables.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.GodTestAbstract;
import god.codegen.tables.mapper.GodTablesMapper;

public class GodTablesMapperTest extends GodTestAbstract {

	@Autowired
	private GodTablesMapper godTablesMapper;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		List<EgovMap> tables = godTablesMapper.selectList();

		egovLogger.debug("tables: {}", tables);
		egovLogger.debug("size: {}", tables.size());

		for (EgovMap table : tables) {
			egovLogger.debug("table: {}", table);
			egovLogger.debug("tableSchema: {}", table.get("tableSchema"));
			egovLogger.debug("tableName: {}", table.get("tableName"));
			egovLogger.debug("tableComment: {}", table.get("tableComment"));
		}
	}

}
