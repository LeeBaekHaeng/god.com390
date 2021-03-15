package com.example.demo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.EmplyrInfo;

@Mapper
public interface EmplyrInfoMapper {
	EmplyrInfoMapper INSTANCE = Mappers.getMapper(EmplyrInfoMapper.class);

//	@Mapping(source = "mberId", target = "mberId")
	EmplyrInfoDto entityToDto(EmplyrInfo entity);

//	@Mapping(source = "mberId", target = "mberId")
	EmplyrInfo dtoToEntity(EmplyrInfoDto dto);
}
