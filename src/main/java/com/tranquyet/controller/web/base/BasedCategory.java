package com.tranquyet.controller.web.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.service.CategoryService;

public class BasedCategory {

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("categoryList")
	public CategoryDTO getCategory() {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setListResult(categoryService.findAll());
		return categoryDTO;
	}

}
