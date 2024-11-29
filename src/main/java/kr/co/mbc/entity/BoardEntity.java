package kr.co.mbc.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kr.co.mbc.dto.BoardDto;
import kr.co.mbc.dto.BoardResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	
	private String content;
	
	private String createDate;
	
	private String updateDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(nullable = false)
	private MemberEntity member;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<ReplyEntity> replyList;
	
	
	public static BoardEntity toBoardEntity(BoardDto boardDto) {
		
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String naljja = sdf.format(d);
		
		BoardEntity boardEntity = BoardEntity.builder().title(boardDto.getTitle()).content(boardDto.getContent())
				.createDate(naljja).updateDate(naljja).build();
		
		return boardEntity;
	}
	
	public static BoardResponse toBoardResponse(BoardEntity boardEntity) {
		
		BoardResponse response = BoardResponse.builder().id(boardEntity.getId()).title(boardEntity.getTitle()).writer(boardEntity.getMember().getUserId())
				.content(boardEntity.getContent()).createDate(boardEntity.getCreateDate()).updateDate(boardEntity.getUpdateDate()).build();
		
		return response;
	}
	
	
	
	
}
