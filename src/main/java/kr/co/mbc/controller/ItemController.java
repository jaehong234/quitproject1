package kr.co.mbc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.co.mbc.dto.ItemDto;
import kr.co.mbc.dto.ItemResponse;
import kr.co.mbc.service.ItemService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;

	@PostMapping("/delete")
	public String delete(String itemId) {
		
		System.out.println(itemId);
		
		itemService.deleteByItemId(itemId);
		
		return "redirect:/item/list";
	}
	
	@PostMapping("/update")
	public String update(ItemDto itemDto) {
		
		itemService.update(itemDto);
		
		ItemResponse itemResponse = itemService.findByItemName(itemDto.getItemName());

		return "redirect:/item/read/" + itemResponse.getItemId();
	}

	@GetMapping("/update/{itemId}")
	public String update(@PathVariable("itemId") String itemId, Model model) {

		ItemResponse itemResponse = itemService.findByItemId(itemId);

		model.addAttribute("itemResponse", itemResponse);

		return "item/update";
	}

	@GetMapping("/list")
	public void list(Model model) {

		List<ItemResponse> list = itemService.findAll();

		model.addAttribute("list", list);

	}

	@GetMapping("/read/{itemId}")
	public String read(@PathVariable("itemId") @ModelAttribute("itemId") String itemId, Model model) {

		ItemResponse itemResponse = itemService.findByItemId(itemId);

		model.addAttribute("itemResponse", itemResponse);

		return "/item/read";
	}

	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("itemDto") ItemDto itemDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "redirect:/item/insert";
		}

		itemService.save(itemDto);

		ItemResponse itemResponse = itemService.findByItemName(itemDto.getItemName());

		return "redirect:/item/read/" + itemResponse.getItemId();
	}

	@GetMapping("/insert")
	public void insert() {

	}

}
