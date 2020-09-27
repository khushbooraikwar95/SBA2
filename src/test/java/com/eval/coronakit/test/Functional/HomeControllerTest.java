package com.eval.coronakit.test.Functional;

import static com.eval.coronakit.test.utils.TestUtils.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eval.coronakit.controller.HomeController;

@WebMvcTest(HomeController.class)
@RunWith(SpringRunner.class)
public class HomeControllerTest {
	@InjectMocks
	private HomeController homeController;

	@Autowired
	private MockMvc mockMvc;

	@Before 
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHomePage() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
						
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getForwardedUrl());
		
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().endsWith("index.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testMainMenuPageAdminAccess() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home")
				.with(user("Admin").password("abc").roles("ADMIN"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("main-menu.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testMainMenuPageUserAccess() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("main-menu.jsp")) ? true : false,
					businessTestFile);
	}
}
