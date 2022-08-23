package com.zlimbu.utst.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

//@TestPropertySource(locations = {"classpath:test-specific.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/get-all-items", String.class);
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", response, false);
	}
}
