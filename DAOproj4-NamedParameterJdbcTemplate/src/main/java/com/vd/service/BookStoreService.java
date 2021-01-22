package com.vd.service;

import java.sql.SQLException;
import java.util.List;

import com.vd.dto.BookDTO;

public interface BookStoreService {
	public List<BookDTO> getBookByAuthor(String author1,String author2,String author3);
	public String registerBook(BookDTO dto);
	
}
