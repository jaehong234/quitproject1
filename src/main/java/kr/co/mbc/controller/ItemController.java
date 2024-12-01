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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.validation.Valid;
import kr.co.mbc.dto.ItemDto;
import kr.co.mbc.dto.ItemResponse;
import kr.co.mbc.entity.AttachEntity;
import kr.co.mbc.service.ItemService;
import kr.co.mbc.utils.UploadFileUtils;
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

		List<AttachEntity> attachList = itemResponse.getAttachList();

		for(AttachEntity attachEntity : attachList) {
			
			String filename = attachEntity.getFilename();
			model.addAttribute("filename", filename);
		}
		

		model.addAttribute("itemResponse", itemResponse);

		return "/item/read";
	}

	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("itemDto") ItemDto itemDto, BindingResult bindingResult,
			MultipartHttpServletRequest mRequest) {

		if (bindingResult.hasErrors()) {

			return "redirect:/item/insert";
		}

		MultipartFile file = mRequest.getFile("quitfile");

		String fullFilename = UploadFileUtils.uploadFile(file);

		System.out.println(fullFilename);

		itemDto.setFilename(fullFilename);

		itemService.save(itemDto);

		return "redirect:/item/list";
	}

	@GetMapping("/insert")
	public void insert() {

	}

}
