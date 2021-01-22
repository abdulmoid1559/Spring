package com.vd.dao;

import java.util.List;

import com.vd.bo.BookBO;

public interface BookStoreDAO {
	public List<BookBO> getBookByAuthor(String author1,String author2,String author3);
	public int insertBook(BookBO bo);
}
