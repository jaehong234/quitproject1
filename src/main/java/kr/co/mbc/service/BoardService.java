package kr.co.mbc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.repository.BoardRepository;
import kr.co.mbc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	private final MemberRepository memberRepository;

	public MemberEntity findByuserId(String member) {
		MemberEntity byUserId = memberRepository.findByUserId(member);
		
		return byUserId;
	}

	public void save(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);		
	}

	public BoardEntity findById(Long id) {
		Optional<BoardEntity> opt = boardRepository.findById(id);
		
		if(opt.isEmpty()) {
			return null;
		}
		BoardEntity boardEntity = opt.get();
		
		return boardEntity;
		
	}

	public List<BoardEntity> findAll() {
		
		return boardRepository.findAll();
	}

	public void update(BoardEntity boardEntity) {
		
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String naljja = sdf.format(d);
		
		boardEntity.setUpdateDate(naljja);
		
		boardRepository.save(boardEntity);
		
	}
	
	@Transactional
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
		
	}

	
	
	
	
	
}
