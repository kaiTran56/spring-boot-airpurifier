package com.tranquyet.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> findAll(Pageable page);

	List<ProductDTO> findByCategory(CategoryDTO dto);
	
	List<ProductDTO> findByManufacture(ManufactureDTO dto);
	
	List<ProductDTO> findNewProduct();
	
	List<ProductDTO> findOldProduct();
	
	int getTotalItem();

	ProductDTO findById(long id);

	ProductDTO save(ProductDTO dto);

	void delete(long[] ids);
	
	

}
