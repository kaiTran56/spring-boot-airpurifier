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

import com.tranquyet.dto.NewsDTO;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.service.NewsService;
import com.tranquyet.service.TopicService;

@Controller(value = "newsAdmin")
@RequestMapping("/admin/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private TopicService topicService;

	@GetMapping("/list")
	public String show(@RequestParam(name = "page", required = false) Optional<Integer> page,
			@RequestParam(name = "limit", required = false) Optional<Integer> limit, Model model) {

		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setPage(page.orElse(0));
		newsDTO.setLimit(limit.orElse(5));
		newsDTO.setCurrentPage(page.orElse(0));

		Pageable pageRequest = PageRequest.of(page.orElse(1) - 1, limit.orElse(5));
		newsDTO.setListResult(newsService.findAll(pageRequest));
		newsDTO.setTotalItem(newsService.getTotalItem());

		int totalPage = (int) Math.ceil((double) newsDTO.getTotalItem() / newsDTO.getLimit());

		newsDTO.setTotalPage(totalPage);

		model.addAttribute("newsModel", newsDTO);

		return "admin/news/news";
	}

	@GetMapping("/delete/{id}")
	public String deleteNews(@PathVariable("id") long id) {
		long[] ids = { id };
		newsService.delete(ids);
		return "redirect:/admin/news/list";
	}

	@ModelAttribute("news_detail")
	public NewsDTO get() {
		return new NewsDTO();
	}

	@PostMapping("/create")
	public String save(@ModelAttribute("news_detail") NewsDTO newsDTO) {
		newsService.save(newsDTO);
		return "redirect:/admin/news/create?success";
	}

	@ModelAttribute("topic")
	public TopicDTO getTopic() {
		TopicDTO topicDTO = new TopicDTO();
		topicDTO.setListResult(topicService.findAll());
		topicDTO.setTotalItem(topicService.findAll().size());
		return topicDTO;
	}

	@GetMapping("/create")
	public String getSave(@ModelAttribute("topic") TopicDTO topicDTO) {
		return "admin/news/create";
	}

	// edit

	@GetMapping("/edit/{id}")
	public String getEdit(Model model, @ModelAttribute("news") NewsDTO newsDTO, @PathVariable("id") long id,
			@ModelAttribute("topic") TopicDTO topicDTO) {

		newsDTO = newsService.findById(id);

		model.addAttribute("news", newsDTO);

		return "admin/news/detail";

	}

	@PostMapping("/edit")
	public String saveEdit(@ModelAttribute("news") NewsDTO newsDTO) {
		newsService.save(newsDTO);
		return "redirect:/admin/news/list";
	}

}
