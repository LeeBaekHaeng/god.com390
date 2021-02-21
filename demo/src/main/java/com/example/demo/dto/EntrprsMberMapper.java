package com.example.demo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.EntrprsMber;

@Mapper
public interface EntrprsMberMapper {
	EntrprsMberMapper INSTANCE = Mappers.getMapper(EntrprsMberMapper.class);

//	@Mapping(source = "mberId", target = "mberId")
	EntrprsMberDto entityToDto(EntrprsMber entity);

//	@Mapping(source = "mberId", target = "mberId")
	EntrprsMber dtoToEntity(EntrprsMberDto dto);
}
