package com.vd.service;

import java.util.List;

import com.vd.dto.BookDTO;

public interface BookStoreMgmtService {
	public List<BookDTO> fetchAllBook();
}
