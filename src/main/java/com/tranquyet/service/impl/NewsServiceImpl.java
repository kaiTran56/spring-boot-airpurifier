package com.tranquyet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquyet.converter.NewsConverter;
import com.tranquyet.converter.TopicConverter;
import com.tranquyet.dto.NewsDTO;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.entity.NewsEntity;
import com.tranquyet.entity.TopicEntity;
import com.tranquyet.repository.NewsRepository;
import com.tranquyet.repository.TopicRepository;
import com.tranquyet.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private NewsConverter converter;

	@Autowired
	private TopicConverter topicConverter;

	@Override
	public List<NewsDTO> findAll(Pageable page) {
		List<NewsDTO> listDTO = new ArrayList<>();
		List<NewsEntity> listEntity = newsRepository.findAll(page).getContent();
		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));
		return listDTO;
	}

	@Override
	public List<NewsDTO> findByTopic(TopicDTO dto) {
		List<NewsDTO> listDTO = new ArrayList<>();
		List<NewsEntity> listEntity = newsRepository.findByTopic(topicConverter.toEntity(dto));
		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));
		return listDTO;
	}

	@Override
	public int getTotalItem() {

		return (int) newsRepository.count();
	}

	@Override
	public NewsDTO findById(long id) {

		return converter.toDTO(newsRepository.findOneById(id));
	}

	@Override
	public NewsDTO save(NewsDTO dto) {
		TopicEntity topicEntity = topicRepository.findOneByName(dto.getTopicCode());
		NewsEntity newsEntity = new NewsEntity();
		if (dto.getId() != null) {
			NewsEntity oldEntity = newsRepository.findOneById(dto.getId());
			newsEntity = converter.toEntity(dto, oldEntity);
			oldEntity.setTopic(topicEntity);
			
		} else {
			newsEntity = converter.toEntity(dto);
			newsEntity.setTopic(topicEntity);
			
		}
		return converter.toDTO(newsRepository.save(newsEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newsRepository.deleteById(id);
		}
	}

}
