package com.green.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.entity.Board;
import com.green.entity.File;
import com.green.entity.Section;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository br;
	
	@Autowired
	SectionRepository sr;
	
	@Autowired
	FileRepository fr;
	
	@Test
	public void insertSection() {
		
		for(int i=1; i<=4; i++) {
		
			Section section = null;
			
					switch(i) {
						case 1:
							section = Section.builder().
							sectionName("모든 권한").
							build();
							break;
						case 2:
							section = Section.builder().
							sectionName("VR 아카이빙").
							build();
							break;
						case 3:
							section = Section.builder().
							sectionName("동영상").
							build();
							break;
						case 4:
							section = Section.builder().
							sectionName("디지털 조감도").
							build();
							break;
					}
					
					sr.save(section);
					
		}
	}
	
	@Test
	public void insertBoard() {

			LocalDate now = LocalDate.now();
			
			Random random = new Random();
			
			for(int i=1; i<=500; i++) {
				
				int randomValue = random.nextInt(3)+2;
				int randomWriterDate = random.nextInt(3)+2024;
				
				if(randomValue == 2) {
					Board board = Board.builder().
//							boardWriteYear(now.getYear()).
							boardWriteYear(randomWriterDate).
							boardTitle("vr, 글 제목 "+i).
							boardContent("글 내용 "+i).
							viewCount(0).
							section(sr.findById(randomValue).orElse(null)).
							build();
					br.save(board);
				}else if(randomValue == 3) {
					Board board = Board.builder().
//							boardWriteYear(now.getYear()).
							boardWriteYear(randomWriterDate).
							boardTitle("동영상, 글 제목 "+i).
							boardContent("글 내용 "+i).
							viewCount(0).
							section(sr.findById(randomValue).orElse(null)).
							build();
					br.save(board);
				}else if(randomValue == 4) {
					Board board = Board.builder().
//							boardWriteYear(now.getYear()).
							boardWriteYear(randomWriterDate).
							boardTitle("디지털 조감도, 글 제목 "+i).
							boardContent("글 내용 "+i).
							viewCount(0).
							section(sr.findById(randomValue).orElse(null)).
							build();
					br.save(board);
				}

			}
			
	}
	
}
