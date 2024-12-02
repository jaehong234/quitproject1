package kr.co.mbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.mbc.entity.AttachEntity;
import kr.co.mbc.repository.AttachRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttachService {

	private final AttachRepository attachRepository;

	public List<AttachEntity> findAll() {
		
		return attachRepository.findAll();
	}
	
}
