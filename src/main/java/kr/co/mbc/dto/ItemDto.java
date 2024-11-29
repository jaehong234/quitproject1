package kr.co.mbc.dto;

import jakarta.validation.constraints.NotBlank;
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
public class ItemDto {
	
	@NotBlank(message = "상품이름은 필수 입력입니다.")
	private String itemName;
	
	@NotBlank(message = "상품가격은 필수 입력입니다.")
	private String itemPrice;
	
	@NotBlank(message = "상품설명은 필수 입력입니다.")
	private String itemInfo;

}
