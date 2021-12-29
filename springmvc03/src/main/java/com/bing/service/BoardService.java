package com.bing.service;

import java.util.List;

import com.bing.model.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();

	public void register(BoardVO board);

	public BoardVO get(int bno, String mode);

	public int remove(int bno);

	public int modify(BoardVO board);

}
