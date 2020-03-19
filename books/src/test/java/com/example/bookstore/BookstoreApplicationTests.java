package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.net.BookController;
import com.example.bookstore.net.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bcontroller;
	
	@Autowired
	private UserController ucontroller;
	
	// Smoketests for controllers
	@Test
	public void contextLoads() throws Exception {
		assertThat(bcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}

}
