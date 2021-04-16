package com.tranquyet.converter;

import org.springframework.stereotype.Component;

import com.tranquyet.dto.ProductDTO;
import com.tranquyet.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setId(dto.getId());
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setShortDescription(dto.getShortDescription());
		result.setFullDescription(dto.getFullDescription());
		result.setPrice(dto.getPrice());
		result.setSale(dto.getSale());
		result.setQuantity(dto.getQuantity());
		result.setSale(dto.getSale());
		result.setImage_1(dto.getImage_1());
		result.setImage_2(dto.getImage_2());
		result.setImage_3(dto.getImage_3());
		result.setImage_4(dto.getImage_4());
		result.setShoppeeUrl(dto.getShoppeeUrl());
		result.setYoutubeUrl(dto.getYoutubeUrl());
		result.setCategory(dto.getCategory());
		result.setManufacture(dto.getManufacture());
		return result;
	}

	public ProductEntity toEntity(ProductDTO dto, ProductEntity result) {
		result.setId(dto.getId());
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setShortDescription(dto.getShortDescription());
		result.setFullDescription(dto.getFullDescription());
		result.setPrice(dto.getPrice());
		result.setSale(dto.getSale());
		result.setQuantity(dto.getQuantity());
		result.setSale(dto.getSale());
		result.setImage_1(dto.getImage_1());
		result.setImage_2(dto.getImage_2());
		result.setImage_3(dto.getImage_3());
		result.setImage_4(dto.getImage_4());
		result.setShoppeeUrl(dto.getShoppeeUrl());
		result.setYoutubeUrl(dto.getYoutubeUrl());
		result.setCategory(dto.getCategory());
		result.setManufacture(dto.getManufacture());
		return result;
	}

	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setShortDescription(entity.getShortDescription());
		result.setFullDescription(entity.getFullDescription());
		result.setPrice(entity.getPrice());
		result.setSale(entity.getSale());
		result.setQuantity(entity.getQuantity());
		result.setSale(entity.getSale());
		result.setImage_1(entity.getImage_1());
		result.setImage_2(entity.getImage_2());
		result.setImage_3(entity.getImage_3());
		result.setImage_4(entity.getImage_4());
		result.setShoppeeUrl(entity.getShoppeeUrl());
		result.setYoutubeUrl(entity.getYoutubeUrl());
		result.setCategory(entity.getCategory());
		result.setManufacture(entity.getManufacture());
		return result;
	}

}
