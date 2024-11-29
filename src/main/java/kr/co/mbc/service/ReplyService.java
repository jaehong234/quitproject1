package kr.co.mbc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.ReplyEntity;
import kr.co.mbc.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;

	public void save(String val, BoardEntity boardEntity) {
		
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String naljja = sdf.format(d);
		
		ReplyEntity replyEntity = ReplyEntity.builder().replyContent(val).createDate(naljja).board(boardEntity).build();
		
		replyRepository.save(replyEntity);
	}

	public List<ReplyEntity> findByBoard(BoardEntity boardEntity) {
		List<ReplyEntity> replyList= replyRepository.findByBoard(boardEntity);
		return replyList;
	}

	@Transactional
	public void deleteById(long replyId) {
		replyRepository.deleteById(replyId);
	}

	public ReplyEntity findById(Long replyId) {
		Optional<ReplyEntity> opt = replyRepository.findById(replyId);
		
		if(opt.isEmpty()) {
			return null;
			
		}
		return opt.get();
	}


	public void update(ReplyEntity replyEntity) {
		replyRepository.save(replyEntity);
		
	}
	
	
	
	
}
