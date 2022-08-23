package com.zlimbu.utst.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zlimbu.utst.business.ItemBusinessService;
import com.zlimbu.utst.model.Item;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	

	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void getItemTest() throws Exception {
		// GET /hello Application/Json
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("{\"id\":1,\"name\":\"pencil\",\"price\":12,\"quantity\":5}", result.getResponse().getContentAsString());
	}
	
	
	@Test
	public void getItemFrinBusinessServiceTest() throws Exception {
		// GET /hello Application/Json
		
		when(this.businessService.retrieveHardCodedItem()).thenReturn(new Item(2,"Book", 23, 45));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("{\"id\":2,\"name\":\"Book\",\"price\":23,\"quantity\":45}", result.getResponse().getContentAsString());
	}

	@Test
	public void getAllItemsTest() throws Exception{
		
		when(this.businessService.retrieveAll()).thenReturn(Arrays.asList(new Item(1, "pen",45, 3)
				,new Item(2, "book",75, 2)
				,new Item(3, "marble",23, 4)
				,new Item(4, "sweet",76, 7)
				));
		RequestBuilder request = MockMvcRequestBuilders.get("/get-all-items").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("[{\"id\":1,\"name\":\"pen\",\"price\":45,\"quantity\":3,\"value\":48},{\"id\":2,\"name\":\"book\",\"price\":75,\"quantity\":2,\"value\":79},{\"id\":3,\"name\":\"marble\",\"price\":23,\"quantity\":4,\"value\":35},{\"id\":4,\"name\":\"sweet\",\"price\":76,\"quantity\":7,\"value\":104}]", result.getResponse().getContentAsString());
	}
}
