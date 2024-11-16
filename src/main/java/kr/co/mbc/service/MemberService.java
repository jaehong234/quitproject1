package kr.co.mbc.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import kr.co.mbc.dto.MemberDTO;
import kr.co.mbc.dto.MemberResponse;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository; 
	
	public static MemberResponse toMemberResponse(MemberEntity entity) {
		MemberResponse memberResponse = MemberResponse.builder()
				.userId(entity.getUserId()).name(entity.getName())
				.phoneNum(entity.getPhoneNum()).email(entity.getEmail())
				.address(entity.getAddress()).gender(entity.getGender())
				.createDate(entity.getCreateDate()).updateDate(entity.getUpdateDate())
				.build();
		
		return memberResponse;
	}
	
	
	public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nallja = sdf.format(d);
		
		MemberEntity entity = MemberEntity.builder().userId(memberDTO.getUserId())
				.pass(memberDTO.getPass()).name(memberDTO.getName()).phoneNum(memberDTO.getPhoneNum())
				.email(memberDTO.getEmail()).address(memberDTO.getAddress())
				.gender(memberDTO.getGender()).createDate(nallja).updateDate(nallja)
				.build();
		
		return entity;
	}


	public void save(MemberDTO memberDTO) {
		MemberEntity entity = toMemberEntity(memberDTO);
		
		memberRepository.save(entity);
		
	}


	public List<MemberResponse> findAll() {
		List<MemberEntity> entityList = memberRepository.findAll();
		
		List<MemberResponse> responseList = new ArrayList<MemberResponse>();
		
		for(MemberEntity entity : entityList) {
			MemberResponse memberResponse = toMemberResponse(entity);
			responseList.add(memberResponse);
		}
		
		return responseList;
	}
	
	
}
