package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.BookBO;
import com.vd.dto.BookDTO;
import com.vd.repository.BookStoreRepository;

@Service("bookService")
public class BookStoreMgmtServiceImpl implements BookStoreMgmtService {
	@Autowired
	private BookStoreRepository bookRepo;
	@Override
	public List<BookDTO> fetchAllBook() {
		List<BookDTO> listDTO=new ArrayList<BookDTO>();
		Iterable<BookBO> listBO=null;
		
		listBO=bookRepo.findAll();
		
		listBO.forEach(bo->{
		BookDTO dto=new BookDTO();
		BeanUtils.copyProperties(bo, dto);
		listDTO.add(dto);
		System.out.println(dto);
		});
		return listDTO;
	}

}
