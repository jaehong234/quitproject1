package kr.co.mbc.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import kr.co.mbc.dto.MemberDto;
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
	
	
	public static MemberEntity toMemberEntity(MemberDto memberDto) {
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nallja = sdf.format(d);
		
		MemberEntity entity = MemberEntity.builder().userId(memberDto.getUserId())
				.pass(memberDto.getPass()).name(memberDto.getName()).phoneNum(memberDto.getPhoneNum())
				.email(memberDto.getEmail()).address(memberDto.getAddress())
				.gender(memberDto.getGender()).createDate(nallja).updateDate(nallja)
				.build();
		
		return entity;
	}


	public void save(MemberEntity memberEntity) {
		
		memberRepository.save(memberEntity);
		
	}


	public List<MemberEntity> findAll() {
		List<MemberEntity> entityList = memberRepository.findAll();
		
		return entityList;
	}


	public MemberEntity findByUserId(String userId) {
		
		MemberEntity memberEntity = memberRepository.findByUserId(userId);
		
		return memberEntity;
	}


	public void update(MemberDto memberDto) {
		
		MemberEntity entity = memberRepository.findByUserId(memberDto.getUserId());
		
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String naljja = sdf.format(d);
		
		entity.setName(memberDto.getName());
		entity.setPhoneNum(memberDto.getPhoneNum());
		entity.setEmail(memberDto.getEmail());
		entity.setAddress(memberDto.getAddress());
		entity.setUpdateDate(naljja);
		
		
		memberRepository.save(entity);
		
	}

	@Transactional
	public void deleteByUserId(String userId) {
		memberRepository.deleteByUserId(userId);
		
	}
	
	
}
