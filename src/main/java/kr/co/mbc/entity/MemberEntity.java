package kr.co.mbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name =  "member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // pk
	
	@Column(unique = true, nullable = false)
	private String userId; // id
	
	@Column(nullable = false)
	private String pass; // pw
	
	@Column(nullable = false)
	private String name; // 이름
	
	@Column(nullable = false)
	private String phoneNum; // 연락처
	
	@Column(nullable = false)
	private String email; // 이메일
	
	@Column(nullable = false)
	private String address; // 주소
	
	private String gender; // 성별
	
	private String createDate; // 생성일
	private String updateDate; // 수정일
	

}
