package kr.co.mbc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.mbc.entity.AttachEntity;
import kr.co.mbc.service.AttachService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final AttachService attachService;
	
	@GetMapping("/")
	public String main(Model model) {
		
		List<AttachEntity> attachList = attachService.findAll();
		
		model.addAttribute("attachList", attachList);
		
		return "/main";
	}
}
