package com.eval.coronakit.test.Exception;

import static com.eval.coronakit.test.utils.TestUtils.exceptionTestFile;
import static com.eval.coronakit.test.utils.TestUtils.currentTest;
import static com.eval.coronakit.test.utils.TestUtils.yakshaAssert;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eval.coronakit.controller.AdminController;
import com.eval.coronakit.controller.UserController;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@WebMvcTest({AdminController.class, UserController.class})
@RunWith(SpringRunner.class)
public class SecurityExceptionTest {
	
	@InjectMocks
	private UserController userController;

	@InjectMocks
	private AdminController adminController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
	
	@MockBean
	CoronaKitService coronaKitService;
	
	@MockBean
	KitDetailService kitDetailService;
	
	@Before 
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMainMenuPageWithoutCredentials() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home"); // R : custom-login
				
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getRedirectedUrl() !=null && result.getResponse().getRedirectedUrl().endsWith("custom-login")) ? true : false,
					exceptionTestFile);
	}
	
	
	@Test
	public void testMainMenuPageInvalidCredentials() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home") // R : custom-login
				.with(user("Admin").password("abc").roles("XYZ"));	// custom-error F				
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("custom-error")) ? true : false,
					exceptionTestFile);
	}
	
	
	@Test
	public void testAdminHomeInvalidCredential() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/home")
				.with(user("Admin").password("abc").roles("XYZ"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("custom-error")) ? true : false,
							exceptionTestFile);
	}
	
	@Test
	public void testUserHomeInvalidCredential() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/home")
				.with(user("First").password("abc").roles("XYZ"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("custom-error")) ? true : false,
							exceptionTestFile);
	}
}
