package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service; // boardservice 객체가 제대로 주입이 가능한지
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

	// 게시물 등록 테스트
//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새 작성 글 ");
//		board.setContent("새 작성 내용");
//		board.setWriter("new111");
//		
//		service.register(board);
//		log.info("생성된 게시물 번호 :" + board.getBno());
//	}
	
	// 게시물 리스트 테스트
//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
//	}
//	
	// 게시물 조회 테스트
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	
	// 게시물 삭제 테스트
//	@Test 
//	public void testDelete() {
//		log.info("REMOVE RESULT: "+ service.remove(4L));
//
//	}
	
	// 게시물 수정 테스트
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		board.setTitle("제목 수정 테스트");
		log.info("MODIFY RESULT :" + service.modify(board));
	}
}
