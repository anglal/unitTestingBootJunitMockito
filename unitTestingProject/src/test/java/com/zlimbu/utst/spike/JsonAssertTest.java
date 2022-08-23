package com.zlimbu.utst.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	
	String actualResponse = "{\"id\":1,\"name\":\"Pencil\",\"price\":12,\"quantity\":100}";
	@Test
	public void jsonAssertStrictTrueExactMatchButSpaceIsFine() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Pencil\",\"price\":12,\"quantity\":100}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
	}
	
	@Test
	public void jsonAssertStrictFalseExactMatchButSpaceIsFine() throws JSONException{
		String expectedResponse = "{\"id\":1,\"name\":\"Pencil\",\"price\":12}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
