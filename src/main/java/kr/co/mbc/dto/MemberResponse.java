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
public class MemberResponse {
	
	private String userId; // id
	
	private String name; // 이름
	
	private String phoneNum; // 연락처
	
	private String email; // 이메일
	
	private String address; // 주소
	
	private String gender; // 성별
	
	private String createDate; // 생성일
	private String updateDate; // 수정일
	
	
}
