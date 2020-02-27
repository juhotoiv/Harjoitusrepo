package com.example.bookstore.net;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bookstore.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;

	public void demoFindByTitle() {
		List<Book> books = brepository.findByTitle("Kirja 1");
		System.out.println(books);
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/booklist")
	public String showBookList(Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		brepository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	brepository.deleteById(bookId);
	return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model){
	model.addAttribute("book", brepository.findById(bookId));
	model.addAttribute("categories", crepository.findAll());
	return "editbook";
	}
	
}
