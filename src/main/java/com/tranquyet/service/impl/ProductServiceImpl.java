package com.tranquyet.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquyet.converter.CategoryConverter;
import com.tranquyet.converter.ManufactureConverter;
import com.tranquyet.converter.ProductConverter;
import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.entity.CategoryEntity;
import com.tranquyet.entity.ManufactureEntity;
import com.tranquyet.entity.ProductEntity;
import com.tranquyet.repository.CategoryRepository;
import com.tranquyet.repository.ManufactureRepository;
import com.tranquyet.repository.ProductRepository;
import com.tranquyet.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter converter;

	@Autowired
	private CategoryConverter categoryConverter;

	@Autowired
	private ManufactureConverter manufactureConverter;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ManufactureRepository manufactureRepository;

	public List<ProductDTO> findAll(Pageable page) {
		List<ProductDTO> dto = new ArrayList<ProductDTO>();
		List<ProductEntity> entity = productRepository.findAll(page).getContent();

		entity.forEach(p -> {
			dto.add(converter.toDTO(p));
		});

		return dto;
	}

	public int getTotalItem() {

		return (int) productRepository.count();
	}

	public ProductDTO findById(long id) {
		return converter.toDTO(productRepository.findOneById(id));
	}

	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByName(dto.getCategoryCode());
		ManufactureEntity manufacture = manufactureRepository.findOneByName(dto.getManufactureCode());
		ProductEntity newEntity = new ProductEntity();
		if (dto.getId() != null) {
			Optional<ProductEntity> oldEntity = productRepository.findById(dto.getId());
			oldEntity.get().setCategory(category);
			oldEntity.get().setManufacture(manufacture);
			newEntity = converter.toEntity(dto, oldEntity.get());

		} else {
			newEntity = converter.toEntity(dto);
			newEntity.setCategory(category);
			newEntity.setManufacture(manufacture);
		}
		return converter.toDTO(productRepository.save(newEntity));

	}

	public void delete(long[] ids) {

		for (long id : ids) {
			productRepository.deleteById(id);
		}

	}

	@Override
	public List<ProductDTO> findByCategory(CategoryDTO dto) {

		List<ProductDTO> listDTO = new ArrayList<>();

		List<ProductEntity> listEntity = productRepository.findByCategory(categoryConverter.toEntity(dto));

		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));

		return listDTO;
	}

	@Override
	public List<ProductDTO> findByManufacture(ManufactureDTO dto) {
		List<ProductDTO> listDTO = new ArrayList<>();

		List<ProductEntity> listEntity = productRepository.findByManufacture(manufactureConverter.toEntity(dto));

		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));

		return listDTO;
	}

	@Override
	public List<ProductDTO> findNewProduct() {
		List<ProductDTO> listDTO = new ArrayList<>();

		List<ProductEntity> listEntity = productRepository.findNewProduct();

		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));

		return listDTO;

	}

	@Override
	public List<ProductDTO> findOldProduct() {
		List<ProductDTO> listDTO = new ArrayList<>();

		List<ProductEntity> listEntity = productRepository.findOldProduct();

		listEntity.forEach(p -> listDTO.add(converter.toDTO(p)));

		return listDTO;
	}
	

}
