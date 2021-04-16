package com.tranquyet.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.ProductService;

@Controller(value = "productAdmin")
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public String product() {

		return "admin/product/product";
	}

	@ModelAttribute("product")
	public ProductDTO productDto() {
		return new ProductDTO();
	}

	@GetMapping("/list")
	public String show(@RequestParam(name = "page", required = false) Optional<Integer> page,
			@RequestParam(name = "limit", required = false) Optional<Integer> limit,

			 Model model) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page.orElse(0));
		productDTO.setLimit(limit.orElse(5));
		productDTO.setCurrentPage(page.orElse(0));
		
		Pageable pageRequest = PageRequest.of(page.orElse(1)-1, limit.orElse(5));
		productDTO.setListResult(productService.findAll(pageRequest));
		productDTO.setTotalItem(productService.getTotalItem());

		
		int totalPage = (int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit());
		productDTO.setTotalPage(totalPage);
		
		model.addAttribute("test", "HelloWorld!");
		
		model.addAttribute("model",productDTO);

		return "admin/product/product";

	}

}
