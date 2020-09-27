package com.eval.coronakit.test.Functional;

import static com.eval.coronakit.test.utils.TestUtils.businessTestFile;
import static com.eval.coronakit.test.utils.TestUtils.currentTest;
import static com.eval.coronakit.test.utils.TestUtils.yakshaAssert;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
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

import com.eval.coronakit.controller.UserController;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;
import com.eval.coronakit.test.utils.MasterData;



@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {
	@InjectMocks
	private UserController userController;

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
	public void testUserHome() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/home")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("user-home.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testUserShowKit() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/show-kit")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("show-cart.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testUserListAllProduct() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/show-list")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("show-all-item-user.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testUserAddProductToKit() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/add-to-cart/1")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getRedirectedUrl() !=null && result.getResponse().getRedirectedUrl().endsWith("show-kit")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testUserCheckout() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/checkout")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("checkout-address.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testUserFinalizeOrder() throws Exception {
		
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/finalize")
				.param("address", "some address")
				.with(user("First").password("abc").roles("ADMIN"))
				.with(csrf());
				
						
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		
		
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("show-summary.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testUserDeleteItemFormKit() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/delete/1")
				.with(user("First").password("abc").roles("USER"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getRedirectedUrl() !=null && result.getResponse().getRedirectedUrl().endsWith("show-kit")) ? true : false,
					businessTestFile);
	}
	
}
