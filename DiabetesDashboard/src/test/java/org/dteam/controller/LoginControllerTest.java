package org.dteam.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class LoginControllerTest {

	@InjectMocks
	private LoginController logincontroller = new LoginController();

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(logincontroller).setViewResolvers(viewResolver).build();
	}

	// Test should return 404 error as the requestmapping is for /login
	@Test
	public void testGetMethodWithWrongRequest() throws Exception {
		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isNotFound());
	}

	// Test should return Http 200 as the requestmapping is for /login
	@Test
	public void testGetMethodWithCorrectRequest() throws Exception {

		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("login"));
	}

	// Test checks whether page gets redirected to "dashboard.jsp"
	@Test
	public void testPostMethodWithCorrectRequest() throws Exception {

		this.mockMvc.perform(post("/login")).andDo(print()).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/dashboard"));
	}

}
