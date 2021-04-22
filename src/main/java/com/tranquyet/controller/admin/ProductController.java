package com.tranquyet.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.CategoryService;
import com.tranquyet.service.ManufactureService;
import com.tranquyet.service.ProductService;

@Controller(value = "productAdmin")
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ManufactureService manufactureService;

	@GetMapping()
	public String product() {

		return "admin/product/product";
	}

	@ModelAttribute("productController")
	public ProductDTO productDto() {
		return new ProductDTO();
	}

	@GetMapping("/list")
	public String show(@RequestParam(name = "page", required = false) Optional<Integer> page,
			@RequestParam(name = "limit", required = false) Optional<Integer> limit, Model model) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page.orElse(0));
		productDTO.setLimit(limit.orElse(5));
		productDTO.setCurrentPage(page.orElse(0));

		Pageable pageRequest = PageRequest.of(page.orElse(1) - 1, limit.orElse(5));
		productDTO.setListResult(productService.findAll(pageRequest));
		productDTO.setTotalItem(productService.getTotalItem());

		int totalPage = (int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit());
		productDTO.setTotalPage(totalPage);
		model.addAttribute("model", productDTO);
		return "admin/product/product";

	}

	@ModelAttribute("manufacture")
	public ManufactureDTO getManufacture() {

		ManufactureDTO manufactureDTO = new ManufactureDTO();
		manufactureDTO.setListResult(manufactureService.findAll());
		manufactureDTO.setTotalItem(manufactureService.findAll().size());
		return manufactureDTO;

	}

	@ModelAttribute("category")
	public CategoryDTO getCategory() {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setListResult(categoryService.findAll());
		categoryDTO.setTotalItem(categoryService.findAll().size());
		return categoryDTO;
	}

	@GetMapping("/create")
	public String showCreate(@ModelAttribute("category") CategoryDTO categoryDTO,
			@ModelAttribute("manufacture") ManufactureDTO manufactureDTO, Model model) {

		return "admin/product/create";
	}

	@PostMapping("/create")
	public String createProduct(@ModelAttribute("productController") ProductDTO product) {
		productService.save(product);
		return "redirect:/admin/product/create?success";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id") long id) {
		long[] ids = { id };
		productService.delete(ids);
		return "redirect:/admin/product/list";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@ModelAttribute("category") CategoryDTO categoryDTO,
			@ModelAttribute("manufacture") ManufactureDTO manufactureDTO, @PathVariable("id") long id, Model model) {

		ProductDTO product = productService.findById(id);

		model.addAttribute("product_detail", product);

		return "admin/product/detail";
	}

	@PostMapping("/editSave")
	public String editProduct(@ModelAttribute("product_detail") ProductDTO product) {
		productService.save(product);
		return "redirect:/admin/product/list";
	}

}
