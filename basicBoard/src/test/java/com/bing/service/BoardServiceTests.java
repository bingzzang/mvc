package com.bing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bing.domain.BoardVO;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {

	@Autowired
	private BoardService service;

//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}

//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//
//		service.register(board);
//
//		log.info("생성된 게시물의 번호 : " + board.getBno());
//	}

//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
//	}

	@Test
	public void testGet() {
		log.info(service.get(3L));
	}

	@Test
	public void testDelete() {
		log.info("Remove Result : " + service.remove(2L));
	}

	@Test
	public void testUpdate() {
		BoardVO board = service.get(3L);

		if (board == null) {
			return;
		}

		board.setTitle("제목 수정합니다");
		log.info("Modify Result : " + service.modify(board));
	}
}
