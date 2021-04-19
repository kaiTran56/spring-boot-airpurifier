package com.tranquyet.converter;

import org.springframework.stereotype.Component;

import com.tranquyet.dto.NewsDTO;
import com.tranquyet.entity.NewsEntity;

@Component
public class NewsConverter {

	public NewsEntity toEntity(NewsDTO dto) {
		NewsEntity result = new NewsEntity();
		result.setId(dto.getId());
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setImage_1(dto.getImage_1());
		result.setImage_2(dto.getImage_2());
		result.setImage_3(dto.getImage_3());
		result.setImage_4(dto.getImage_4());
		result.setShoppeeUrl(dto.getShoppeeUrl());
		result.setYoutubeUrl(dto.getYoutubeUrl());
		result.setAuthor(dto.getAuthor());
		return result;
	}

	public NewsEntity toEntity(NewsDTO dto, NewsEntity result) {
		result.setId(dto.getId());
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setImage_1(dto.getImage_1());
		result.setImage_2(dto.getImage_2());
		result.setImage_3(dto.getImage_3());
		result.setImage_4(dto.getImage_4());
		result.setShoppeeUrl(dto.getShoppeeUrl());
		result.setYoutubeUrl(dto.getYoutubeUrl());
		result.setAuthor(dto.getAuthor());
		return result;
	}

	public NewsDTO toDTO(NewsEntity entity) {
		NewsDTO result = new NewsDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setTopicCode(entity.getTopic().getName());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setImage_1(entity.getImage_1());
		result.setImage_2(entity.getImage_2());
		result.setImage_3(entity.getImage_3());
		result.setImage_4(entity.getImage_4());
		result.setShoppeeUrl(entity.getShoppeeUrl());
		result.setYoutubeUrl(entity.getYoutubeUrl());
		result.setAuthor(entity.getAuthor());
		return result;
	}
	
}
