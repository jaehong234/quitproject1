package kr.co.mbc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoardResponse {
	
	private Long id;

	private String title;
	
	private String writer;
	
	private String content;
	
	private String createDate;
	
	private String updateDate;
	
}
