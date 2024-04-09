package com.green.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;
import com.green.entity.Board;
import com.green.repository.BoardRepository;
import com.green.repository.SectionRepository;

@Service
public class BoardServiceImpe implements BoardService {

	@Autowired
	BoardRepository br;
	
	@Autowired
	SectionRepository sr;
	
	@Override
	public List<BoardVO> getMainVrList() {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(0, 3, sort);
		
		Page<Board> result = br.getBoardPage(2, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getBoardWriteYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			boardVO.setBoardFile(board.getBoardFile());
			
			list.add(boardVO);
			
		}

		return list;
		
	}

	@Override
	public List<BoardVO> getMainVideoList() {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(0, 3, sort);
		
		Page<Board> result = br.getBoardPage(3, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardFile(board.getBoardFile());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());

			list.add(boardVO);
			
		}
		
		return list;
		
	}

	@Override
	public List<BoardVO> getVrList(ConditionValue cv) {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);
		
		Page<Board> result = br.getBoardPage(2, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getBoardWriteYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			boardVO.setBoardFile(board.getBoardFile());

			list.add(boardVO);
			
		}
		
		return list;
		
	}

	@Override
	public List<BoardVO> getVideoList(ConditionValue cv) {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);
		
		Page<Board> result = br.getBoardPage(3, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardFile(board.getBoardFile());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			
			list.add(boardVO);
			
		}
		
		return list;
		
	}

	@Override
	public int getVrCount() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPage(2, pageable);
		
		return (int)result.getTotalElements();
		
	}

	@Override
	public int getVideoCount() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPage(3, pageable);
		
		return (int)result.getTotalElements();
		
	}

	@Override
	public void vrWrite(BoardVO boardVO, int sectionNo) {
		
		LocalDateTime now = LocalDateTime.now();
		
		int LocalDateValue = now.getYear();
		
		Board board = Board.builder().
				boardTitle(boardVO.getBoardTitle()).
				boardContent(boardVO.getBoardContent()).
				boardFile(boardVO.getBoardFile()).
				boardWriteYear(LocalDateValue).
				section(sr.findById(sectionNo).orElse(null)).
				build();
		br.save(board);
	}

	@Override
	public void videoWrite(BoardVO boardVO, int sectionNo) {
		
		LocalDateTime now = LocalDateTime.now();
		
		int LocalDateValue = now.getYear();
		
		Board board = Board.builder().
				boardTitle(boardVO.getBoardTitle()).
				boardContent(boardVO.getBoardContent()).
				boardFile(boardVO.getBoardFile()).
				section(sr.findById(sectionNo).orElse(null)).
				build();
		br.save(board);
		
	}

	@Override
	public Board getVrView(Long boardNo) {
		
		Optional<Board> result = br.findById(boardNo);
		
		if(result.isPresent()) {
			
			Board board = result.get();
			
			return board;
			
		}
		
		return null;
	}

	@Override
	public Board getVideoView(Long boardNo) {
		
		Optional<Board> result = br.findById(boardNo);
		
		if(result.isPresent()) {
			
			Board board = result.get();
			
			return board;
			
		}
		
		return null;
	}
	
}
