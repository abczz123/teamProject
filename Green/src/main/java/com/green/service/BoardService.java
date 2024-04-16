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
	public List<BoardVO> getVrListOne(ConditionValue cv);
	public List<BoardVO> getVrListTwo(ConditionValue cv);
	public List<BoardVO> getVrListThree(ConditionValue cv);
	
	public List<BoardVO> getVideoList(ConditionValue cv);
	
	public int getVrCount();
	public int getVrCountOne();
	public int getVrCountTwo();
	public int getVrCountThree();
	
	public int getVideoCount();
	
	public long vrWrite(BoardVO boardVO, int sectionNo);
	public long videoWrite(BoardVO boardVO, int sectionNo);
	
	public Board getVrView(Long boardNo);
	public List<File> getVrViewImage(Long boardNo);
	
	public Board getClipView(Long boardNo);
	public List<File> getClipViewVideo(Long boardNo);
	
	public void imageUpload(long boardNo, List<MultipartFile> files);
	public void videoUpload(long boardNo, String YoutubeLink);
	
	public Board get(long boardNo);
	
	public void vrModify(BoardVO boardVO, int sectionNo);
	public void clipModify(BoardVO boardVO, String youtubeLink, int sectionNo, long fileNo);
	
	public void imageModify(BoardVO boardVO, long fileNo, List<MultipartFile> files);
	
	public long getFileNo(BoardVO boardVO);
	public long getFileNo2(BoardVO boardVO);
	
	public void vrRemove(long boardNo);
	public void clipRemove(long boardNo);
	
}
