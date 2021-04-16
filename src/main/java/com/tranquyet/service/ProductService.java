package com.tranquyet.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tranquyet.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> findAll(Pageable page);

	int getTotalItem();

	ProductDTO findById(long id);

	ProductDTO save(ProductDTO dto);

	void delete(long[] ids);

}
