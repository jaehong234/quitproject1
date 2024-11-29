package kr.co.mbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.ReplyEntity;
import kr.co.mbc.service.BoardService;
import kr.co.mbc.service.ReplyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService replyService;
	
	private final BoardService boardService;
	
	@PutMapping("/")
	public String update(@RequestBody Map<String, String>map) {
		
		String strreplyId = map.get("id");
		Long replyId = Long.parseLong(strreplyId);
		
		String content = map.get("content");
		
		ReplyEntity replyEntity= replyService.findById(replyId);
		
		replyEntity.setReplyContent(content);
		
		replyService.update(replyEntity);
		
		return "put";
	}

	@DeleteMapping("/")
	public String delete(@RequestBody Map<String, String> map) {
		
		String strReplyId = map.get("id");
		long ReplyId = Long.parseLong(strReplyId);
		
		replyService.deleteById(ReplyId);
		
		return "delete";
	}
	
	@GetMapping("/{id}")
	public List<ReplyEntity> getReplyList(@PathVariable("id")Long id) {
		
		
		BoardEntity boardEntity = boardService.findById(id);
		
		List<ReplyEntity> replyList = replyService.findByBoard(boardEntity);
		
		return replyList;
	}
	
	@PostMapping("/")
	public String insert(@RequestBody Map<String, String> map) {
		
		String val = map.get("content");
		
		String readId = map.get("id");
		long realId = Long.parseLong(readId);
		
		
		BoardEntity boardEntity = boardService.findById(realId);
		replyService.save(val, boardEntity);
		
		return "ok";
	}
}
