package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			log.info("save demo categories to db");
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Non-fiction"));
			
			log.info("save demo book lines to db");
			brepository.save(new Book("Kirja 1", "Maija", 2020, "978-951-51-4165-1", 19.99, crepository.findByName("Sci-Fi").get(0)));
			brepository.save(new Book("Kirja 2", "Matti", 2019, "978-951-51-4165-2", 10, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("Kirja 3", "Pekka", 1999, "978-951-51-4165-3", 1899.99, crepository.findByName("Non-fiction").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
