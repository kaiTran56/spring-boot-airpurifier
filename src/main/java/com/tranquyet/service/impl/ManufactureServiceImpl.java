package com.tranquyet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranquyet.converter.ManufactureConverter;
import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.entity.ManufactureEntity;
import com.tranquyet.repository.ManufactureRepository;
import com.tranquyet.service.ManufactureService;

@Service
public class ManufactureServiceImpl implements ManufactureService {

	@Autowired
	private ManufactureRepository manufactureRepository;

	@Autowired
	private ManufactureConverter converter;

	@Override
	public List<ManufactureDTO> findAll() {
		List<ManufactureDTO> listDTO = new ArrayList<>();

		List<ManufactureEntity> entity = manufactureRepository.findAll();
		entity.forEach(p -> listDTO.add(converter.toDTO(p)));

		return listDTO;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ManufactureDTO findById(long id) {
		
		return converter.toDTO(manufactureRepository.findOneById(id));
	}

	@Override
	public ManufactureDTO save(ManufactureDTO dto) {
		ManufactureEntity newEntity = new ManufactureEntity();
		if (dto != null) {
			ManufactureEntity oldEntity = new ManufactureEntity();
			newEntity = converter.toEntity(dto, oldEntity);
		} else {
			newEntity = converter.toEntity(dto);
		}
		return converter.toDTO(manufactureRepository.save(newEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			manufactureRepository.deleteById(id);
		}
	}

}
