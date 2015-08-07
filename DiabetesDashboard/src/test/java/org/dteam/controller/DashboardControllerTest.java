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

public class DashboardControllerTest {

	@InjectMocks
	private DashboardController dashboardcontroller = new DashboardController();

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(dashboardcontroller).setViewResolvers(viewResolver).build();
	}

	// Test should return 404 error as the requestmapping is for /dashboard
	@Test
	public void testGetMethodWithWrongRequest() throws Exception {
		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isNotFound());
	}

	// Test should return Http 200 as the requestmapping is for /dashboard
	// redirects to login page as user is not logged in
	@Test
	public void testGetMethodWithCorrectRequestButNoUserLogin() throws Exception {
		this.mockMvc.perform(get("/dashboard")).andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("login"));
	}

	@Test
	public void testPostMethodWithCorrectRequest() throws Exception {

		this.mockMvc.perform(post("/dashboard")).andDo(print()).andExpect(status().isOk())
				.andExpect(model().attributeExists("Msg")).andExpect(view().name("dashboard"));
	}

}
