package com.bing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bing.mapper.BoardMapper;
import com.bing.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired // DI주입(의존성 주입)
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
	}

	@Override
	public BoardVO get(int bno, String mode) {

		if (mode.equals("get")) {
			mapper.readcount(bno);
		}
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		return mapper.delete(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.update(board);
	}

}
