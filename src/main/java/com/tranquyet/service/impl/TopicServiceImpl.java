package com.tranquyet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranquyet.converter.TopicConverter;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.entity.TopicEntity;
import com.tranquyet.repository.TopicRepository;
import com.tranquyet.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private TopicConverter converter;

	@Override
	public List<TopicDTO> findAll() {
		List<TopicDTO> listDTO = new ArrayList<>();
		List<TopicEntity> listEntity = topicRepository.findAll();
		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));
		return listDTO;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TopicDTO findById(long id) {
		return converter.toDTO(topicRepository.findOneById(id));
	}

	@Override
	public TopicDTO save(TopicDTO dto) {
		TopicEntity newEntity = new TopicEntity();

		if (dto.getId() != null) {
			TopicEntity oldEntity = topicRepository.findOneById(dto.getId());

			newEntity = converter.toEntity(dto, oldEntity);
		} else {
			newEntity = converter.toEntity(dto);
		}
		return converter.toDTO(topicRepository.save(newEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			topicRepository.deleteById(id);
		}

	}

}
