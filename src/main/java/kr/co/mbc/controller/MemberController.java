package kr.co.mbc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import kr.co.mbc.dto.MemberDto;
import kr.co.mbc.dto.MemberResponse;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping("/delete")
	public String delete(MemberDto memberDto) {
		memberService.deleteByUserId(memberDto.getUserId());
		
		return "redirect:/member/list";
	}
	
	@PostMapping("/update")
	public String update(MemberDto memberDto) {
		
		memberService.update(memberDto);
		
		return "redirect:/member/read/" + memberDto.getUserId();
	}
	
	@GetMapping("/update/{userId}")
	public String update(@PathVariable("userId")String userId, Model model) {
		
		MemberEntity memberEntity = memberService.findByUserId(userId);
		
		MemberResponse memberResponse = MemberService.toMemberResponse(memberEntity);
		
		model.addAttribute("mres", memberResponse);
		
		return "/member/update";
	}
	
	@GetMapping("/read/{userId}")
	public String read(@PathVariable("userId") String userId, Model model) {
		
		 MemberEntity memberEntity = memberService.findByUserId(userId);
		 
		 MemberResponse memberResponse = MemberService.toMemberResponse(memberEntity);
		 
		 model.addAttribute("memberResponse", memberResponse);
		
		return "/member/read";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		
		List<MemberEntity> list = memberService.findAll();
		
		List<MemberResponse> responseList = new ArrayList<MemberResponse>();
		
		for(MemberEntity memberEntity : list) {
			MemberResponse memberResponse = MemberService.toMemberResponse(memberEntity);
			responseList.add(memberResponse);
		}
		
		model.addAttribute("responseList", responseList);
		
	}
	
	@PostMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam Map<String, String> map) {
		String val = map.get("userId");
			
		if(val.isEmpty()) {
			return "no";
		}
		
		MemberEntity memberEntity = memberService.findByUserId(val);
			
		if(memberEntity == null) {
			return "ok";
		}
		
		return "no";
	}
	
	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("memberDTO") MemberDto memberDto
			, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/member/insert";
		}
		
		if(memberDto.getPass().equals(memberDto.getPass2())) {
			return "/member/insert";
		}
		
		MemberEntity memberEntity = MemberService.toMemberEntity(memberDto);
		
		memberService.save(memberEntity);
		
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	
}
