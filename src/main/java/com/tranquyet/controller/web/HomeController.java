package com.tranquyet.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tranquyet.controller.web.base.BasedCategory;
import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.dto.NewsDTO;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.ManufactureService;
import com.tranquyet.service.NewsService;
import com.tranquyet.service.ProductService;

@Controller(value = "homeUser")
public class HomeController extends BasedCategory {

	@Autowired
	private NewsService newsService;

	@Autowired
	private ManufactureService manufactureService;

	@Autowired
	private ProductService productService;

	@ModelAttribute("manufactureList")
	public ManufactureDTO getManufacture() {
		ManufactureDTO dto = new ManufactureDTO();
		dto.setListResult(manufactureService.findAll());
		return dto;
	}

	@ModelAttribute("productList")
	public ProductDTO getProduct() {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setListResult(productService.findNewProduct());
		return productDTO;
	}

	@ModelAttribute("oldProductList")
	public ProductDTO getOldProduct() {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setListResult(productService.findNewProduct());
		return productDTO;
	}

	@ModelAttribute("newest")
	public NewsDTO getNews() {
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setListResult(newsService.findNewest());
		return newsDTO;
	}

	@GetMapping("/trang-chu")
	public String getHome(@ModelAttribute("categoryList") CategoryDTO categoryDTO,
			@ModelAttribute("manufactureList") ManufactureDTO manufactureDTO,
			@ModelAttribute("productList") ProductDTO productDTO,
			@ModelAttribute("oldProductList") ProductDTO oldProductDTO, @ModelAttribute("newest") NewsDTO newsDTO) {

		return "web/index";
	}

	@GetMapping("/")
	public String index() {
		return "redirect:/trang-chu";
	}

	@GetMapping("/lien-he")
	public String getContact(@ModelAttribute("categoryList") CategoryDTO categoryDTO) {
		return "web/contact/contact";
	}

	

}
