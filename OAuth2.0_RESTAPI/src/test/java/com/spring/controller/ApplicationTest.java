package com.spring.controller;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.GoogleAuth;
import com.spring.rest.GoogleOAuthAPI;

import lombok.extern.log4j.Log4j;
import retrofit2.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ApplicationTest {

	@Autowired
	private GoogleOAuthAPI googleOAuthAPI;

	@Test
	public void test() throws IOException {

		String code = "4/0gChjss0cmPlf4yuFyY-4QuDB0BBd0C1fINO0NOTp7ywQbFW-maWKyvW1-LzUR_WLirx83ZaDjRf7N0QdH-a_4M";

		Response<GoogleAuth> response = googleOAuthAPI.getToken(GoogleOAuthAPI.TOKEN_STATIC_FILED_MAP, code).execute();

		System.out.println(response);
	}
}
