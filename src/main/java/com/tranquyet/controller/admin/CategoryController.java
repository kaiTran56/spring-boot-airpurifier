package com.tranquyet.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranquyet.dto.CategoryDTO;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.CategoryService;
import com.tranquyet.service.ProductService;

@Controller(value = "adminCategory")
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@ModelAttribute("category")
	public CategoryDTO getCategory() {
		CategoryDTO dto = new CategoryDTO();
		dto.setListResult(categoryService.findAll());
		dto.setTotalItem(categoryService.findAll().size());
		return dto;
	}

	@GetMapping("/list")
	public String showCategory(@ModelAttribute("category") CategoryDTO categoryDTO) {

		return "admin/category/category";

	}

	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") long id) {
		long[] ids = { id };

		CategoryDTO dto = new CategoryDTO();
		dto.setId(id);

		Optional<List<ProductDTO>> listDTO = Optional.of(productService.findByCategory(dto));

		if (!listDTO.isEmpty()) {
			listDTO.get().forEach(p -> {
				p.setCategoryCode("option");
				productService.save(p);
			});
		}

		categoryService.delete(ids);

		return "redirect:/admin/category/list";

	}

	@PostMapping("/editSave")
	public String saveCategory(@ModelAttribute("category") CategoryDTO dto) {

		categoryService.save(dto);

		return "redirect:/admin/category/list";

	}
	
	@ModelAttribute("categoryController")
	public CategoryDTO categoryDTO() {
		return new CategoryDTO();
	}
	
	
	@GetMapping("/create")
	public String createCategory() {
		return "admin/category/create";
	}
	
	@PostMapping("/create")
	public String save(@ModelAttribute("categoryController") CategoryDTO cateDTO) {
		categoryService.save(cateDTO);
		return "redirect:/admin/category/create?success";
	}
	

	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") long id, Model model) {

		CategoryDTO dto = categoryService.findById(id);

		model.addAttribute("category_detail", dto);

		return "admin/category/detail";

	}

}
