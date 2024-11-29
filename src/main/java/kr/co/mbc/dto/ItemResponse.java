package kr.co.mbc.dto;

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
public class ItemResponse {
	
	private String itemId;
	
	private String itemName;
	
	private String itemPrice;
	
	private String itemInfo;
	
	private String createDate;
	private String updateDate;

}