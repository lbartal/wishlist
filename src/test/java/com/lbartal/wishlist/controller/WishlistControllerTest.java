package com.lbartal.wishlist.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WishlistControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getWishlist() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/wishlist").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("{\"wishlist\":[],\"id\":0}")));
	}

	@Test
	public void putWishlist() throws Exception {
		String requestBody = resourceToString("controller/wishlist/PostRequestBody.json");
		String responseBody = resourceToString("controller/wishlist/PostResponseBody.json");
		mvc.perform(MockMvcRequestBuilders.post("/wishlist").contentType("application/json").content(requestBody)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(responseBody, true));
	}

	private String resourceToString(String filePath) throws IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filePath).getFile());
		return new String(Files.readAllBytes(Paths.get(file.getPath())));
	}
}