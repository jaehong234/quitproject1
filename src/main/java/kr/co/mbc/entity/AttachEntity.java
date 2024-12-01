package kr.co.mbc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String filename;
	
	private String createDate;
	private String updateDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(nullable = false)
	private ItemEntity item;

	@Override
	public String toString() {
		return "AttachEntity [id=" + id + ", filename=" + filename + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", item=" + item + "]";
	}
	
	
	
}
