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

import com.tranquyet.dto.ManufactureDTO;
import com.tranquyet.dto.ProductDTO;
import com.tranquyet.service.ManufactureService;
import com.tranquyet.service.ProductService;

@Controller(value = "adminManufacture")
@RequestMapping("/admin/manufacture")
public class ManufactureController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ManufactureService manufactureService;

	@ModelAttribute("manufacture")
	public ManufactureDTO getManufacture() {
		ManufactureDTO manufactureDTO = new ManufactureDTO();
		manufactureDTO.setListResult(manufactureService.findAll());
		return manufactureDTO;
	}

	@GetMapping("/list")
	public String showManufacture(@ModelAttribute("manufacture") ManufactureDTO manufactureDTO) {
		return "admin/manufacture/manufacture";
	}

	@ModelAttribute("manufactureController")
	public ManufactureDTO manufactureDTO() {

		return new ManufactureDTO();
	}
	
	@GetMapping("/create")
	public String createManufacture() {
		
		return "admin/manufacture/create";
		
	}
	@PostMapping("/create")
	public String createManu(@ModelAttribute("manufactureController") ManufactureDTO manufactureDTO) {
		
		manufactureService.save(manufactureDTO);
		
		return "redirect:/admin/manufacture/create?success";
		
	}
	
	@PostMapping("/saveEdit")
	public String edit(@ModelAttribute("manufacture_detail") ManufactureDTO dto) {
		
		manufactureService.save(dto);
		
		return "redirect:/admin/manufacture/list";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editManufacture(@PathVariable("id") long id, Model model) {
		
		ManufactureDTO dto = new ManufactureDTO();
		
		dto = manufactureService.findById(id);
		
		model.addAttribute("manufacture_detail",dto);
		
		return "admin/manufacture/detail";
	}
		

	@GetMapping("/delete/{id}")
	public String deleteManufacture(@PathVariable("id") long id) {

		long[] ids = { id };
		ManufactureDTO dto = new ManufactureDTO();
		dto.setId(id);
		Optional<List<ProductDTO>> listDTO = Optional.of(productService.findByManufacture(dto));

		if (!listDTO.isEmpty()) {
			listDTO.get().forEach(p -> {
				p.setManufactureCode("option");
				productService.save(p);
			});
		}

		manufactureService.delete(ids);

		return "redirect:/admin/manufacture/list";
	}

}
