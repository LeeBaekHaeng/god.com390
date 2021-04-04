package com.example.demo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.CmmnClCode;

@Mapper
public interface CmmnClCodeMapper {
	CmmnClCodeMapper INSTANCE = Mappers.getMapper(CmmnClCodeMapper.class);

//	@Mapping(source = "mberId", target = "mberId")
	CmmnClCodeDto entityToDto(CmmnClCode entity);

//	@Mapping(source = "mberId", target = "mberId")
	CmmnClCode dtoToEntity(CmmnClCodeDto dto);
}
