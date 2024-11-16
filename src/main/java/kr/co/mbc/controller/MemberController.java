package kr.co.mbc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.co.mbc.dto.MemberDTO;
import kr.co.mbc.dto.MemberResponse;
import kr.co.mbc.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	
	@GetMapping("/list")
	public void list(Model model) {
		
		List<MemberResponse> list = memberService.findAll();
		
		model.addAttribute("list", list);
		
	}
	
	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("memberDTO") MemberDTO memberDTO
			, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/member/insert";
		}
		
//		if(memberDTO.getPass().equals(memberDTO.getPass2())) {
//			return "/member/insert";
//		}
		
		memberService.save(memberDTO);
		
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
}
