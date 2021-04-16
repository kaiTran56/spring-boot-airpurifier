package com.tranquyet.dto;

import com.tranquyet.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of= {"name"})
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO extends BasedDTO<CategoryDTO>{

	private String name;
	
	private ProductEntity product;
	
}
