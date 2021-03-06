package god.test.a1.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.test.a1.mapper.GodTestA1Mapper;
import god.test.a1.service.A1VO;

@Repository
public class GodTestA1DAO {

	private final GodTestA1Mapper mapper;

	public GodTestA1DAO(GodTestA1Mapper mapper) {
		this.mapper = mapper;
	}

	@Cacheable(value = "testCache", key = "#vo.tableSchema")
	public List<EgovMap> selectList(A1VO vo) {
		return mapper.selectList();
	}

	@Cacheable(value = "menuCache", key = "#vo.tableSchema")
	public List<EgovMap> selectList2(A1VO vo) {
		return mapper.selectList();
	}

}
