package com.bing.mapper;

import java.util.List;

import com.bing.model.BoardVO;

/**
 * 영속 계층
 * 
 */

public interface BoardMapper {

	public List<BoardVO> getList(); // 게시물 리스트 가져오기

	public void insert(BoardVO board); // 게시물 입력

	public BoardVO read(int bno); // 게시물 상세보기

	public int delete(int bno); // 게시물 삭제

	public int update(BoardVO board); // 게시물 수정

	public int readcount(int bno);
}
