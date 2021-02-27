package com.vd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.vd.dto.BookDTO;
import com.vd.model.Book;
import com.vd.service.BookStoreMgmtService;

@Controller
public class MainController {
	@Autowired
	private BookStoreMgmtService bookService;
	@GetMapping("/welcome")
	public String generateHomePage(ModelMap map) {
		return "home";
	}
	@GetMapping("allBook")
	public String getAllBooks(Map map) {
		List<BookDTO> listDTO=null;
		List<Book> bookList=new ArrayList<Book>();

		listDTO=bookService.fetchAllBook();
		listDTO.forEach(dto->{
			Book model=new Book();
			BeanUtils.copyProperties(dto, model);
			bookList.add(model);
			System.out.println(model);
		});
		
		map.put("list",bookList);
		return "allbooks";
	}
}
