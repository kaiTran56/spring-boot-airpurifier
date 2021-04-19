package com.tranquyet.converter;

import org.springframework.stereotype.Component;

import com.tranquyet.dto.TopicDTO;
import com.tranquyet.entity.TopicEntity;

@Component
public class TopicConverter {

	public TopicDTO toDTO(TopicEntity entity) {
		TopicDTO newDTO = new TopicDTO();
		newDTO.setId(entity.getId());
		newDTO.setName(entity.getName());
		return newDTO;
	}

	public TopicEntity toEntity(TopicDTO dto) {
		TopicEntity entity = new TopicEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	public TopicEntity toEntity(TopicDTO dto, TopicEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
	
}
