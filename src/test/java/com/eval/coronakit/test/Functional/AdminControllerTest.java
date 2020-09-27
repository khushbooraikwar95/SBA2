package com.eval.coronakit.test.Functional;

import static com.eval.coronakit.test.utils.TestUtils.businessTestFile;
import static com.eval.coronakit.test.utils.TestUtils.currentTest;
import static com.eval.coronakit.test.utils.TestUtils.yakshaAssert;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eval.coronakit.controller.AdminController;
import com.eval.coronakit.controller.HomeController;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.ProductService;
import com.eval.coronakit.test.utils.MasterData;



@WebMvcTest(AdminController.class)
@RunWith(SpringRunner.class)
public class AdminControllerTest {

	@InjectMocks
	private AdminController adminController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
	
	@Before 
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAdminHome() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/home")
				.with(user("Admin").password("abc").roles("ADMIN"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("admin-home.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testAdminProductEntryPage() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/product-entry")
				.with(user("Admin").password("abc").roles("ADMIN"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("add-new-item.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testAddNewProduct() throws Exception {
		
		ProductMaster product = MasterData.getProduct();
		
		// Mockito.when(this.productService.addNewProduct(product)).thenReturn(product);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/product-save")
				
				.param("productName", product.getProductName())
				.param("cost", product.getCost().toString())
				.param("productDescription", product.getProductDescription())
				.with(user("Admin").password("abc").roles("ADMIN"))
				.with(csrf());
				
						
		
		MvcResult result = mockMvc.perform(requestBuilder)
				
				.andReturn();
		
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		
		
		yakshaAssert(currentTest(),	
					(result.getResponse().getRedirectedUrl() !=null && result.getResponse().getRedirectedUrl().endsWith("product-list")) ? true : false,
					businessTestFile);
	}
	
	
	@Test
	public void testAdminProductListPage() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/product-list")
				.with(user("Admin").password("abc").roles("ADMIN"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
					(result.getResponse().getForwardedUrl() !=null && result.getResponse().getForwardedUrl().endsWith("show-all-item-admin.jsp")) ? true : false,
					businessTestFile);
	}
	
	@Test
	public void testAdminDeleteProduct() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/product-delete/1")
				.with(user("Admin").password("abc").roles("ADMIN"));					
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Forwarded : " + result.getResponse().getForwardedUrl());
		System.out.println("Redirected : " + result.getResponse().getRedirectedUrl());
		yakshaAssert(currentTest(),	
				(result.getResponse().getRedirectedUrl() !=null && result.getResponse().getRedirectedUrl().endsWith("product-list")) ? true : false,
					businessTestFile);
	}
}
