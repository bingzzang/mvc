package com.bing.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bing.domain.BoardVO;
import com.bing.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;
//
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}

//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//
//		mapper.insert(board);
//
//		log.info(board);
//	}

//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 SelectKey");
//		board.setContent("새로 작성하는 내용 SelectKey");
//		board.setWriter("newbie");
//
//		mapper.insertSelectKey(board);
//
//		log.info(board);
//	}

//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(5L);
//
//		log.info(board);
//	}

//	@Test
//	public void testDelete() {
//
//		log.info("### Delete Count : " + mapper.delete(2L) + " ###");
//	}

//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		board.setBno(4L);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 글내용");
//		board.setWriter("user00");
//
//		int count = mapper.update(board);
//		log.info("update count : " + count);
//	}

	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
