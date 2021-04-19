package com.tranquyet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranquyet.converter.CategoryConverter;
import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.entity.CategoryEntity;
import com.tranquyet.repository.CategoryRepository;
import com.tranquyet.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter converter;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> listDTO = new ArrayList<>();

		List<CategoryEntity> entity = categoryRepository.findAll();
		entity.forEach(p -> listDTO.add(converter.toDTO(p)));

		return listDTO;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CategoryDTO findById(long id) {
		return converter.toDTO(categoryRepository.findOneById(id));

	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity newEntity = new CategoryEntity();
		if (dto.getId() != null) {
			CategoryEntity oldEntity = categoryRepository.findOneById(dto.getId());
			newEntity = converter.toEntity(dto, oldEntity);
		} else {
			newEntity = converter.toEntity(dto);
		}
		return converter.toDTO(categoryRepository.save(newEntity));
	}

	@Override
	public void delete(long[] ids) {

		for (long id : ids) {
			categoryRepository.deleteById(id);
		}

	}

}
