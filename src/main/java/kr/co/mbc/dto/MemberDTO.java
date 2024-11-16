package kr.co.mbc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class MemberDTO {
	
	@NotBlank(message = "아이디는 필수입력입니다.")
	@Size(min = 3, message = "3자리 이상입력하세요.")
	private String userId; // id
	
	@NotBlank(message = "비밀번호는 필수입력입니다.")
	@Size(min = 5, max = 15, message = "비밀번호는 5~15사이로 입력하세요.")
	private String pass; // pw
	
	@NotBlank(message = "비밀번호는 필수입력입니다.")
	@Size(min = 5, max = 15, message = "비밀번호는 5~15사이로 입력하세요.")
	private String pass2; // pw 확인
	
	@NotBlank(message = "이름는 필수입력입니다.")
	private String name; // 이름
	
	@NotBlank(message = "연락처는 필수입력입니다.")
	private String phoneNum; // 연락처
	
	private String email; // 이메일
	
	private String address; // 주소
	
	private String gender; // 성별
	
}
