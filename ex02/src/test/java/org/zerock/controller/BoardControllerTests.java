package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

// 스프링 테스트 기능 (Tomcat을 실행하지 않고 테스트)
@WebAppConfiguration // WebApplicationContext를 이용하기 위해 선언 

@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })

// JavaConfig
//@ContextConfiguration(classes = {org.zerock.config.RootConfig.class, org.zerock.config.ServletConfig.class} )
@Log4j
public class BoardControllerTests {
	// Tomcat 을 사용하지 않고 URL 테스트
	
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before // JUnit @Before가 적용된 모든 메서드는 모든 테스트 전에 매번 실행되는 메서드가 됨
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		// mockMvc = 가짜 MVC, 가짜로 URL과 파라미터 등을 브라우저에서 사용하는 것처럼 만듦
	}
	
	// 게시물 리스트 테스트
//	@Test
//	// MockMvcRequestBuilders = GET방식의 호출 
//	public void testList() throws Exception {
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap());
//	}
	
	// 게시물 리스트 테스트( 페이징 )
	@Test
	public void testListPaging() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
	}
	// 게시물 등록 테스트
//	@Test
//	//MockMvcRequestBuilders = POST방식의 호출
//	public void testRegister() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새글 제목") //.param()을 통해 전달해야 하는 파라미터를 지정 <input>태그와 유사
//				.param("content", "테스트 새글 내용")
//				.param("writer", "aaa123")).andReturn().getModelAndView().getViewName();
//		log.info(resultPage);
//	}
	
	// 게시물 조회 테스트
//	// 특정 게시물을 조회할 땐 반드시 'bno'파라미터가 필요하므로 param() 을 통해 추가
//	@Test
//	public void testGet() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
//				.param("bno", "2"))
//				.andReturn()
//				.getModelAndView().getModelMap());
//	}

	// 게시물 수정 테스트
//	@Test
//	public void testModify() throws Exception{
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("bno", "1")
//				.param("title","수정된 테스트 새글 제목")
//				.param("content", "수정된 새글 내용")
//				.param("writer", "bbb123"))
//				.andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//	}
	
	// 게시물 삭제 테스트
	// MockMvc파라미터로 전달할때는 문자열로만 처리, 삭제전 데이터베이스 게시물 확인
//	@Test
//	public void testRemove() throws Exception{
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
//				.param("bno", "31")).andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//	}
	
}
