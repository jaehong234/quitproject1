package kr.co.mbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.mbc.dto.ItemResponse;
import kr.co.mbc.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {


	ItemEntity findByItemId(String itemId);

	ItemEntity findByItemName(String itemName);

	void deleteByItemId(String itemId);


}
