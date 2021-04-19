package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = { "code", "name", "categoryCode", "manufactureCode" })
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

	private String categoryCode;

	private long id_manufacture;

	private String manufactureCode;

}
