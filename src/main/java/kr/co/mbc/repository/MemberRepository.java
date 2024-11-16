package kr.co.mbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.mbc.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
