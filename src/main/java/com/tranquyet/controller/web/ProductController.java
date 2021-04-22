package com.tranquyet.controller.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.ProductService;

@Controller(value = "productController")
@RequestMapping("/san-pham")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ModelAttribute("sanpham")
	public ProductDTO product() {
		ProductDTO product = new ProductDTO();
		product.setListResult(productService.findAll(null));
		return product;
	}

	@GetMapping("/")
	public String getProduct(@ModelAttribute("product") ProductDTO productDTO,
			@RequestParam(name = "page", required = false) Optional<Integer> page,
			@RequestParam(name = "limit", required = false) Optional<Integer> limit) {

		productDTO = new ProductDTO();

		productDTO.setPage(page.orElse(0));
		productDTO.setCurrentPage(page.orElse(0));
		productDTO.setLimit(limit.orElse(5));
		Pageable pageRequest = PageRequest.of(page.orElse(1) - 1, limit.orElse(5));
		productDTO.setListResult(productService.findAll(pageRequest));
		productDTO.setTotalItem(productService.getTotalItem());

		int totalPage = (int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit());
		productDTO.setTotalPage(totalPage);

		return "web/product/san_pham";
	}

}
