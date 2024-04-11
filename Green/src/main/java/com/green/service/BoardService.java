package com.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;
import com.green.entity.Board;
import com.green.entity.File;

public interface BoardService {
	
	public List<BoardVO> getMainVrList();
	public List<BoardVO> getMainVideoList();

	public List<BoardVO> getVrList(ConditionValue cv);
	public List<BoardVO> getVideoList(ConditionValue cv);
	
	public int getVrCount();
	public int getVideoCount();
	
	public long vrWrite(BoardVO boardVO, int sectionNo);
	public long videoWrite(BoardVO boardVO, int sectionNo);
	
	public Board getVrView(Long boardNo);
	public List<File> getVrViewImage(Long boardNo);
	
	public Board getVideoView(Long boardNo);
	
	public void imageUpload(long boardNo, MultipartFile file);
	public void videoUpload(long boardNo, MultipartFile file);
	
}
