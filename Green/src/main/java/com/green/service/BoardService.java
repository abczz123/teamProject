package com.green.service;

import java.util.List;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;
import com.green.entity.Board;

public interface BoardService {
	
	public List<BoardVO> getMainVrList();
	public List<BoardVO> getMainVideoList();

	public List<BoardVO> getVrList(ConditionValue cv);
	public List<BoardVO> getVideoList(ConditionValue cv);
	
	public int getVrCount();
	public int getVideoCount();
	
	public void vrWrite(BoardVO boardVO, int sectionNo);
	public void videoWrite(BoardVO boardVO, int sectionNo);
	
	public Board getVrView(Long boardNo);
	public Board getVideoView(Long boardNo);
	
}
