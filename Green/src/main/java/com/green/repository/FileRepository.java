package com.green.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.entity.Board;
import com.green.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {
	List<File> findByBoard(Board board);
	Optional<File> findByBoard_BoardNo(Long boardId);
	Optional<File> findByBoard_BoardNoAndId2(Long boardId, int id2);
}
