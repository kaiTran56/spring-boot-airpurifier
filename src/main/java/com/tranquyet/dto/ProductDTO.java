package com.tranquyet.dto;

import com.tranquyet.entity.CategoryEntity;
import com.tranquyet.entity.ManufactureEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = { "code", "name", "category", "manufacture" })
public class ProductDTO extends BasedDTO<ProductDTO> {

	private String code;

	private String name;

	private String shortDescription;

	private String fullDescription;

	private double price;

	private double sale;

	private int quantity;

	private String status;

	private String image_1;

	private String image_2;

	private String image_3;

	private String image_4;

	private String shoppeeUrl;

	private String youtubeUrl;

	private long id_category;

	private CategoryEntity category;

	private long id_manufacture;

	private ManufactureEntity manufacture;

}
