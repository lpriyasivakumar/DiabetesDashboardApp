package org.dteam.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class A1cControllerTest {
	@InjectMocks
	private A1cController a1cController = new A1cController();

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(a1cController).setViewResolvers(viewResolver).build();
	}

	@Test
	public void testGetMethodWithWrongRequest() throws Exception {
		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void testGetMethodWithCorrectRequest() throws Exception {
		this.mockMvc.perform(get("/A1c")).andDo(print()).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/login"));
	}

	@Test
	public void testPostMethodWithCorrectRequest() throws Exception {
		this.mockMvc.perform(post("/A1c")).andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("databaseError"));
	}

}
