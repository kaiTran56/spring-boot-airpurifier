package com.tranquyet.controller.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranquyet.controller.web.base.BasedCategory;
import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.ProductService;

@Controller(value = "detailProductController")
@RequestMapping("/chi-tiet")
public class DetailProductController extends BasedCategory {

	@Autowired
	private ProductService productService;

	@ModelAttribute("oldProductList")
	public ProductDTO getOldProduct() {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setListResult(productService.findNewProduct());
		return productDTO;
	}

	@GetMapping
	public String getDetail(@ModelAttribute("categoryList") CategoryDTO categoryDTO,
			@ModelAttribute("oldProductList") ProductDTO productDTO,
			@RequestParam(name = "san-pham", required = false) Optional<Long> id, Model model) {

		ProductDTO dto = productService.findById(id.orElse((long) 1));

		model.addAttribute("detailProduct", dto);

		return "/web/product/shop-details";
	}
}
