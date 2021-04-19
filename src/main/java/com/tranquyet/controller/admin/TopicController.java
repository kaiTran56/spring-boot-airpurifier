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

import com.tranquyet.dto.NewsDTO;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.service.NewsService;
import com.tranquyet.service.TopicService;

@Controller(value = "topicAdmin")
@RequestMapping("/admin/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@Autowired
	private NewsService newsService;

	@ModelAttribute("topic")
	private TopicDTO getListTopic() {
		TopicDTO topicDTO = new TopicDTO();
		topicDTO.setListResult(topicService.findAll());
		topicDTO.setTotalItem(topicService.findAll().size());
		return topicDTO;
	}

	@GetMapping("/list")
	public String show(@ModelAttribute("topic") TopicDTO topicDTO) {
		return "admin/topic/topic";
	}

	@GetMapping("/delete/{id}")
	public String delte(@PathVariable("id") long id) {
		long[] ids = { id };
		TopicDTO dto = new TopicDTO();
		dto.setId(id);
		Optional<List<NewsDTO>> listDTO = Optional.of(newsService.findByTopic(dto));

		if (!listDTO.isEmpty()) {
			listDTO.get().forEach(p -> {
				p.setTopicCode("option");
				newsService.save(p);
			});
		}
		topicService.delete(ids);
		return "redirect:/admin/topic/list";
	}

	@ModelAttribute("topicController")
	public TopicDTO get() {
		return new TopicDTO();
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("topicControllers") TopicDTO topicDTO) {
		topicService.save(topicDTO);
		return "redirect:/admin/topic/list";
	}

	@GetMapping("/create")
	public String getCreate() {
		return "admin/topic/create";
	}

	@PostMapping("/editSave")
	public String saveEdit(@ModelAttribute("topic_detail") TopicDTO topicDTO) {
		topicService.save(topicDTO);
		return "redirect:/admin/topic/list?success";

	}

	@GetMapping("edit/{id}")
	public String getEdit(@PathVariable("id") long id, Model model) {
		TopicDTO topicDTO = topicService.findById(id);
		model.addAttribute("topic_detail", topicDTO);
		return "admin/topic/detail";
	}

}
