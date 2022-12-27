package org.zerock.mapper;

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
public class BoardMapperTests {
	// BoardMapperTests는 스프링을 이용하여 BoardMapper 인터페이스의 구현체를 주입받아서 동작
	
	@Setter(onMethod_ =@Autowired )
	private BoardMapper mapper;
	
	// 게시물 리스트 테스트
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
/*
	// 게시물 등록 테스트 (insert)
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성 제목 테스트");
		board.setContent("새로작성 내용 테스트");
		board.setWriter("new11");
		
		mapper.insert(board);
		
		log.info(board); // Lombok이 만들어주는 toString()을 이용해서 bno 멤버 변수의 값을 알아보기위해
	}
	
	// 게시물 등록 테스트(insertSelectKey)
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성 제목 테스트 selectKey");
		board.setContent("새로작성 내용 테스트 selectKey");
		board.setWriter("new11");
		
		mapper.insertSelectKey(board);
		log.info(board);
	}
*/	
	// 존재하는 게시물 번호로 테스트
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
/*	
	// 게시물 삭제 테스트
	// 정상적으로 삭제되면 1 그렇지 않으면 0이 출력되게끔
	@Test
	public void TestDelete() {
		log.info("DELETE COUNT :" + mapper.delete(3L));
	}
*/
	
	//게시물 수정 테스트 , 실행 전 게시글 존재하는지 확인
	@Test
	public void TestUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(5L);
		board.setTitle("수정 제목22");
		board.setContent("수정 내용22");
		board.setWriter("update002");
	
		int count = mapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}
}
