package com.green.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="file_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileNo;
	
	@Column(length=255, nullable=false)
	private String fileUrl;
	
}
