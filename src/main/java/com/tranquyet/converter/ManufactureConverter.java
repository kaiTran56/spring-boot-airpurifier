package com.tranquyet.converter;

import org.springframework.stereotype.Component;

import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.entity.ManufactureEntity;

@Component
public class ManufactureConverter {

	public ManufactureDTO toDTO(ManufactureEntity entity) {
		ManufactureDTO newDTO = new ManufactureDTO();
		newDTO.setId(entity.getId());
		newDTO.setName(entity.getName());
		return newDTO;
	}

	public ManufactureEntity toEntity(ManufactureDTO dto) {
		ManufactureEntity entity = new ManufactureEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	public ManufactureEntity toEntity(ManufactureDTO dto, ManufactureEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}
