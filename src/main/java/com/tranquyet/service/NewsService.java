package com.tranquyet.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tranquyet.dto.NewsDTO;
import com.tranquyet.dto.TopicDTO;

public interface NewsService {
	List<NewsDTO> findAll(Pageable page);

	List<NewsDTO> findByTopic(TopicDTO dto);

	List<NewsDTO> findNewest();

	int getTotalItem();

	NewsDTO findById(long id);

	NewsDTO save(NewsDTO dto);

	void delete(long[] ids);
}
