package com.tranquyet.service;

import java.util.List;

import com.tranquyet.dto.TopicDTO;

public interface TopicService {
	List<TopicDTO> findAll();

	int getTotalItem();

	TopicDTO findById(long id);

	TopicDTO save(TopicDTO dto);

	void delete(long[] ids);
	
	
}
