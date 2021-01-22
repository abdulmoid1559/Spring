package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.BookBO;
import com.vd.dao.BookStoreDAO;
import com.vd.dao.BookStoreDAOImpl;
import com.vd.dto.BookDTO;

@Service("bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {
	@Autowired
	BookStoreDAO dao=null;

	

	@Override
	public String registerBook(BookDTO dto) {
		BookBO bo=null;
		String message=null;
		int count=0;
		
		//convert dto int bo
		bo=new BookBO();
		BeanUtils.copyProperties(dto, bo,"bookId");
		count=dao.insertBook(bo);
		return count==0?"Registration failed":"Registration succeded";
	}



	@Override
	public List<BookDTO> getBookByAuthor(String author1, String author2, String author3) {
		List<BookDTO> listdto;
		List<BookBO> listbo=null;
		
		listdto=new ArrayList<BookDTO>();
		listbo=dao.getBookByAuthor(author1, author2, author3);
		listbo.forEach(bo->{
			BookDTO dto= new BookDTO();
//			dto.setBookId(bo.getBookId());
//			dto.setBookName(bo.getBookName());
//			dto.setCategory(bo.getCategory());
//			dto.setAuthor(bo.getAuthor());
//			dto.setPrice(bo.getPrice());
//			dto.setPublisher(bo.getPublisher());
//			dto.setAvailabilityStatus(bo.getAvailabilityStatus());
			BeanUtils.copyProperties(bo,dto);
			listdto.add(dto);
		});
		return listdto;
	}

}
