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

	@Test
	// MockMvcRequestBuilders = GET방식의 호출 
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
}
