package com.green.entity;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="board_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long boardNo;
	
	@Column
	private int boardWriteYear;
	
	@Column(length=100, nullable=false)
	private String boardTitle;
	
	@Column(length=1000, nullable=false)
	private String boardContent;
	
	@Column(nullable=false)
	private int viewCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="section_no")
	private Section section;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<File> files = new ArrayList<>();
	
}
