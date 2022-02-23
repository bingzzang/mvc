package com.web.exercise.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.exercise.board.dao.BoardDAO;
import com.web.exercise.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;

	private String namespace = "com.jth.exercise.board.mapper.";

	@Override
	public int insertBoard(BoardVO boardVO) {
		return session.insert(namespace + "insertBoard", boardVO);
	}

	@Override
	public List<BoardVO> selectBoardList() {
		return session.selectList(namespace + "selectBoardList");
	}

	@Override
	public BoardVO selectBoardDetail(BoardVO boardVO) {
		return session.selectOne(namespace + "selectBoardDetail", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return session.update(namespace + "updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		return session.delete(namespace + "deleteBoard", boardVO);
	}

}
