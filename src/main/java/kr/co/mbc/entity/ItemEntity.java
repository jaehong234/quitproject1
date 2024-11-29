package kr.co.mbc.entity;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String itemId;
	
	@Column(nullable = false, unique = true)
	private String itemName;
	
	private String itemPrice;
	
	@Column(columnDefinition = "TEXT")
	private String itemInfo;
	
	private String createDate;
	private String updateDate;
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<AttachEntity> attachlist;
	
	 public static String generateRandomString(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 사용할 문자 세트
	        Random random = new Random();
	        StringBuilder result = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length()); // 랜덤 인덱스
	            result.append(characters.charAt(index)); // 랜덤 문자 추가
	        }

	    return result.toString();
	 }
	

}
