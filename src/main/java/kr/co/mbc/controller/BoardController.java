package kr.co.mbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mbc.dto.BoardDto;
import kr.co.mbc.dto.BoardResponse;
import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	
	@GetMapping("/read2/{id}")
	public String read2(@PathVariable("id") Long id, Model model) {
		
		BoardEntity boardEntity = boardService.findById(id);
		
		BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity);
		
		model.addAttribute("boardResponse", boardResponse);
		
		return "/board/read2";
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/delete")
	public String delete(Long id) {
		
		boardService.deleteById(id);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/update")
	public String update(BoardDto boardDto) {
		
		BoardEntity boardEntity = boardService.findById(boardDto.getId());
		
		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setContent(boardDto.getContent());
		
		boardService.update(boardEntity);
		
		return "redirect:/board/read/"+ boardDto.getId();
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable("id")Long id, Model model) {
		
		BoardEntity boardEntity = boardService.findById(id);
		
		BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity);
		
		model.addAttribute("boardResponse", boardResponse);
		
		return "/board/update";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		
		List<BoardEntity> boardList = boardService.findAll();
		
		List<BoardResponse> responseList = new ArrayList<BoardResponse>();
		
		for(BoardEntity boardEntity : boardList) {
			BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity);
			responseList.add(boardResponse);
		}
		
		model.addAttribute("responseList", responseList);
		
	}
	
	@GetMapping("/read/{id}")
	public String read(@PathVariable("id") Long id, Model model) {
		
		BoardEntity boardEntity = boardService.findById(id);
		
		BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity);
		
		model.addAttribute("boardResponse", boardResponse);
		
		return "/board/read";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto boardDto) {
		
		MemberEntity entity = boardService.findByuserId(boardDto.getMember());
		
		if(entity == null) {
			
			return "/board/insert";
		}
		
		BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDto);
		boardEntity.setMember(entity);
		
		boardService.save(boardEntity);
		
		return "redirect:/board/read/"+boardEntity.getId();
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}

}
