package com.tranquyet.converter;

import org.springframework.stereotype.Component;

import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO newDTO = new CategoryDTO();
		newDTO.setId(entity.getId());
		newDTO.setName(entity.getName());
		return newDTO;
	}

	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}
