package com.green.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;
import com.green.entity.Board;
import com.green.entity.File;
import com.green.repository.BoardRepository;
import com.green.repository.FileRepository;
import com.green.repository.SectionRepository;

@Service
public class BoardServiceImpe implements BoardService {

	@Autowired
	BoardRepository br;
	
	@Autowired
	SectionRepository sr;
	
	@Autowired
	FileRepository fr;
	
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
			
			List<File> imageFiles = fr.findByBoard(board);
			boardVO.setImageFiles(imageFiles);
			
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
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());

			List<File> videoFiles = fr.findByBoard(board);
			boardVO.setVideoFiles(videoFiles);
			
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

			List<File> imageFiles = fr.findByBoard(board);
			boardVO.setImageFiles(imageFiles);
			
			list.add(boardVO);
			
		}
		
		return list;
		
	}

	@Override
	public List<BoardVO> getVrListOne(ConditionValue cv) {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);
		
		Page<Board> result = br.getBoardPageAnotherDate(2, 2024, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getBoardWriteYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());

			List<File> imageFiles = fr.findByBoard(board);
			boardVO.setImageFiles(imageFiles);
			
			list.add(boardVO);
			
		}
		
		return list;
		
	}
	
	@Override
	public List<BoardVO> getVrListTwo(ConditionValue cv) {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);
		
		Page<Board> result = br.getBoardPageAnotherDate(2, 2025, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getBoardWriteYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());

			List<File> imageFiles = fr.findByBoard(board);
			boardVO.setImageFiles(imageFiles);
			
			list.add(boardVO);
			
		}
		
		return list;
		
	}
	
	@Override
	public List<BoardVO> getVrListThree(ConditionValue cv) {
		
		Sort sort = Sort.by("boardNo").descending();
		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);
		
		Page<Board> result = br.getBoardPageAnotherDate(2, 2026, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getBoardWriteYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());

			List<File> imageFiles = fr.findByBoard(board);
			boardVO.setImageFiles(imageFiles);
			
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
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			
			List<File> videoFiles = fr.findByBoard(board);
			boardVO.setVideoFiles(videoFiles);
			
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
	public int getVrCountOne() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPageAnotherDate(2, 2024, pageable);
		
		return (int)result.getTotalElements();
		
	}
	
	@Override
	public int getVrCountTwo() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPageAnotherDate(2, 2025, pageable);
		
		return (int)result.getTotalElements();
		
	}
	
	@Override
	public int getVrCountThree() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPageAnotherDate(2, 2026, pageable);
		
		return (int)result.getTotalElements();
		
	}

	@Override
	public int getVideoCount() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPage(3, pageable);
		
		return (int)result.getTotalElements();
		
	}

	@Override
	public long vrWrite(BoardVO boardVO, int sectionNo) {
		
		LocalDateTime now = LocalDateTime.now();
		
		int LocalDateValue = now.getYear();
		
		Board board = Board.builder().
				boardTitle(boardVO.getBoardTitle()).
				boardContent(boardVO.getBoardContent()).
				boardWriteYear(LocalDateValue).
				section(sr.findById(sectionNo).orElse(null)).
				build();
		board = br.save(board);
		
		return board.getBoardNo();
		
	}

	@Override
	public long videoWrite(BoardVO boardVO, int sectionNo) {
		
		LocalDateTime now = LocalDateTime.now();
		
		int LocalDateValue = now.getYear();
		
		Board board = Board.builder().
				boardTitle(boardVO.getBoardTitle()).
				boardContent(boardVO.getBoardContent()).
				section(sr.findById(sectionNo).orElse(null)).
				build();
		
		board = br.save(board);
		
		return board.getBoardNo();
		
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
	public Board getClipView(Long boardNo) {
		
		Optional<Board> result = br.findById(boardNo);
		
		if(result.isPresent()) {
			
			Board board = result.get();
			
			return board;
			
		}
		
		return null;
	}

	@Override
	public void imageUpload(long boardNo, List<MultipartFile> files) {
		
		try {
			
			String fileName = "/images/";
			
			int i = 1;
			
			for(MultipartFile file : files) {
			
				byte[] fileBytes = file.getBytes();
				
				File fileEntity = File.builder().
						id2(i++).
						fileName(fileName+file.getOriginalFilename()).
						board(br.findById(boardNo).orElse(null)).
						build();
				fr.save(fileEntity);
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	                
	}

	@Override
	public void videoUpload(long boardNo, String youtubeLink) {
		
			File fileEntity = File.builder().
					fileName(youtubeLink).
					board(br.findById(boardNo).orElse(null)).
					build();
			fr.save(fileEntity);
			
	}

	@Override
	public List<File> getVrViewImage(Long boardNo) {
		
		Optional<Board> result = br.findById(boardNo);
		
		if(result.isPresent()) {
			
			Board board = result.get();
			
			return board.getFiles();
			
		}
		
		return null;
	}

	@Override
	public List<File> getClipViewVideo(Long boardNo) {
		
		Optional<Board> result = br.findById(boardNo);
		
		if(result.isPresent()) {
			
			Board board = result.get();
			
			return board.getFiles();
			
		}
		
		return null;
		
	}

	@Override
	public Board get(long boardNo) {
		
		Optional<Board> result = br.findById(boardNo);
		
		if(result.isPresent()) {
			Board board = result.get();
			
			return board;
		}
		
		return null;
		
	}

	@Override
	public void vrModify(BoardVO boardVO, int sectionNo) {
		
		System.out.println("게시글 번호 : "+boardVO.getBoardNo());
		System.out.println("게시글 제목 : "+boardVO.getBoardTitle());
		System.out.println("게시글 내용 : "+boardVO.getBoardContent());
		
		Board board = Board.builder().
					boardNo(boardVO.getBoardNo()).
					boardTitle(boardVO.getBoardTitle()).
					boardContent(boardVO.getBoardContent()).
					boardWriteYear(boardVO.getBoardWriteYear()).
					section(sr.findById(sectionNo).orElse(null)).
					build();
					
		br.save(board);
	}

	@Override
	public void imageModify(BoardVO boardVO, long fileNo, List<MultipartFile> files) {
		
		try {
			
			String fileName = "/images/";
			
			int i = 1;
			
			for(MultipartFile file : files) {
				
				byte[] fileBytes = file.getBytes();
				
				File fileEntity = File.builder().
						id(fileNo++).
						id2(i++).
						fileName(fileName+file.getOriginalFilename()).
						board(br.findById(boardVO.getBoardNo()).orElse(null)).
						build();
				fr.save(fileEntity);
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public long getFileNo(BoardVO boardVO) {
		
		Optional<File> result = fr.findByBoard_BoardNoAndId2(boardVO.getBoardNo(), 1);
		
		if(result.isPresent()) {
			
			File file = result.get();
			
			return file.getId();
			
		}
		
		return 0;
		
	}
	
	@Override
	public long getFileNo2(BoardVO boardVO) {
		
		Optional<File> result = fr.findByBoard_BoardNo(boardVO.getBoardNo());
		
		if(result.isPresent()) {
			
			File file = result.get();
			
			return file.getId();
			
		}
		
		return 0;
		
	}

	@Override
	public void vrRemove(long boardNo) {
		
		br.deleteById(boardNo);
		
	}

	@Override
	public void clipModify(BoardVO boardVO, String youtubeLink, int sectionNo, long fileNo) {
		
		Board board = Board.builder().
				boardNo(boardVO.getBoardNo()).
				boardTitle(boardVO.getBoardTitle()).
				boardContent(boardVO.getBoardContent()).
				boardWriteYear(boardVO.getBoardWriteYear()).
				section(sr.findById(sectionNo).orElse(null)).
				build();
		br.save(board);
		
		File file = File.builder().
				id(fileNo).
				fileName(youtubeLink).
				board(br.findById(boardVO.getBoardNo()).orElse(null)).
				build();
		fr.save(file);

	}
	
	@Override
	public void clipRemove(long boardNo) {
		
		br.deleteById(boardNo);
		
	}
	
	
	
}
