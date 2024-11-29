package kr.co.mbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.mbc.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
