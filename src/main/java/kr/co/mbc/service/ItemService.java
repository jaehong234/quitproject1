package kr.co.mbc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.mbc.dto.ItemDto;
import kr.co.mbc.dto.ItemResponse;
import kr.co.mbc.entity.ItemEntity;
import kr.co.mbc.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;
	
	public static ItemEntity toItemEntity(ItemDto itemDto) {
		
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String naljja = sdf.format(d);
		
		String randomString = ItemEntity.generateRandomString(10);
		
		ItemEntity entity = ItemEntity.builder().itemInfo(itemDto.getItemInfo()).itemName(itemDto.getItemName())
				.itemPrice(itemDto.getItemPrice()).createDate(naljja).updateDate(naljja).itemId(randomString).build();
				
		return entity;
	}
	
	public static ItemResponse toItemResponse(ItemEntity itemEntity) {
		
		
		
		ItemResponse itemResponse = ItemResponse.builder().itemId(itemEntity.getItemId()).itemName(itemEntity.getItemName()).itemPrice(itemEntity.getItemPrice())
				.itemInfo(itemEntity.getItemInfo()).createDate(itemEntity.getCreateDate()).updateDate(itemEntity.getUpdateDate()).build();
		
		return itemResponse;
	}
	
	public void save(ItemDto itemDto) {
		
		ItemEntity entity = ItemService.toItemEntity(itemDto);
		
		itemRepository.save(entity);
		
	}

	
	public ItemResponse findByItemId(String itemId) {
		ItemEntity itemEntity= itemRepository.findByItemId(itemId);
		ItemResponse itemResponse = ItemService.toItemResponse(itemEntity);
		
		return itemResponse;
	}
	

	public List<ItemResponse> findAll() {
		List<ItemEntity> entityList = itemRepository.findAll();
		
		List<ItemResponse> respList = new ArrayList<ItemResponse>();
		
		for(ItemEntity entity : entityList) {
			
			ItemResponse itemResponse = ItemService.toItemResponse(entity);
			
			respList.add(itemResponse);
			
		}
		
		return respList;
	}

	public ItemResponse findByItemName(String itemName) {
		ItemEntity itemEntity = itemRepository.findByItemName(itemName);
		
		ItemResponse itemResponse = ItemService.toItemResponse(itemEntity);
		
		return itemResponse;
	}

	public void update(ItemDto itemDto) {
		ItemEntity entity = itemRepository.findByItemName(itemDto.getItemName());
		
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String naljja = sdf.format(d);
		
		entity.setItemPrice(itemDto.getItemPrice());
		entity.setItemInfo(itemDto.getItemInfo());
		entity.setUpdateDate(naljja);
		
		itemRepository.save(entity);
	}
	
	@Transactional
	public void deleteByItemId(String itemId) {
		itemRepository.deleteByItemId(itemId);
		
	}

	
	
	
}
