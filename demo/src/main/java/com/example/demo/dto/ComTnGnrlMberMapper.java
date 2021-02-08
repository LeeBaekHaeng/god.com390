package com.example.demo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.ComTnGnrlMber;

@Mapper
public interface ComTnGnrlMberMapper {
	ComTnGnrlMberMapper INSTANCE = Mappers.getMapper(ComTnGnrlMberMapper.class);

//	@Mapping(source = "mberId", target = "mberId")
	ComTnGnrlMberDTO entityToDto(ComTnGnrlMber entity);

//	@Mapping(source = "mberId", target = "mberId")
	ComTnGnrlMber dtoToEntity(ComTnGnrlMberDTO dto);
}
