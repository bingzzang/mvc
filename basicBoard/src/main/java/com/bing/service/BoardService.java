package com.bing.service;

import java.util.List;

import com.bing.domain.BoardVO;
import com.bing.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);

	public BoardVO get(Long bno);

	public boolean modify(BoardVO board);

	public boolean remove(Long bno);

//	public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
}
