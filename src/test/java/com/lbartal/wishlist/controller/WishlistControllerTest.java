package com.lbartal.wishlist.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
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

import com.lbartal.wishlist.exception.WishlistException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WishlistControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getWishlist() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/wishlist").with(httpBasic("laszlo.bartal@gmail.com", "passwd"))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(
						"{\"wishlist\":[{\"name\":\"Kindle PaperWhite III\",\"description\":\"check out on amazons site\",\"id\":1},{\"name\":\"John Skalzi Book\",\"description\":\"from old mans war series, I read already 1,2,3,4\",\"id\":2}],\"id\":1}")));
	}

	@Test(expected = WishlistException.class)
	public void putWishlist() throws Exception {
		String requestBody = resourceToString("controller/wishlist/PostRequestBody.json");
		String responseBody = resourceToString("controller/wishlist/PostResponseBody.json");
		mvc.perform(MockMvcRequestBuilders.post("/wishlist").contentType("application/json").content(requestBody)
				.with(httpBasic("laszlo.bartal@gmail.com", "passwd")).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(responseBody, true));
		mvc.perform(MockMvcRequestBuilders.post("/wishlist").contentType("application/json").content(requestBody)
				.with(httpBasic("laszlo.bartal@gmail.com", "passwd")).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is5xxServerError());
	}

	private String resourceToString(String filePath) throws IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filePath).getFile());
		return new String(Files.readAllBytes(Paths.get(file.getPath())));
	}
}
