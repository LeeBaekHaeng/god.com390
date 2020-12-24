package god.codegen.columns.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.columns.mapper.GodColumnsMapper;
import god.codegen.columns.service.ColumnsVO;

@Repository
public class GodColumnsDAO {

	private final GodColumnsMapper mapper;

	public GodColumnsDAO(GodColumnsMapper mapper) {
		this.mapper = mapper;
	}

	public List<EgovMap> selectList(ColumnsVO vo) {
		return mapper.selectList(vo);
	}

}
