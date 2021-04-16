package com.tranquyet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquyet.converter.ProductConverter;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.entity.ProductEntity;
import com.tranquyet.repository.ProductRepository;
import com.tranquyet.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter converter;

	public List<ProductDTO> findAll(Pageable page) {
		List<ProductDTO> dto = new ArrayList<ProductDTO>();
		List<ProductEntity> entity = productRepository.findAll(page).getContent();

		entity.forEach(p -> {
			dto.add(converter.toDTO(p));
		});

		return dto;
	}

	public int getTotalItem() {
		
		return (int)productRepository.count();
	}

	public ProductDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDTO save(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long[] ids) {
		// TODO Auto-generated method stub

	}

}
