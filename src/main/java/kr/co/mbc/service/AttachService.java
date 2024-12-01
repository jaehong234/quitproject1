package kr.co.mbc.service;

import org.springframework.stereotype.Service;

import kr.co.mbc.repository.AttachRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttachService {

	private final AttachRepository attachRepository;
	
}
