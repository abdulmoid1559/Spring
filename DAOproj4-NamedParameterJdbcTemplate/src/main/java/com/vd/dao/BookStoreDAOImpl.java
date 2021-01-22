package com.vd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vd.bo.BookBO;

@Repository("bookDAO")
public class BookStoreDAOImpl implements BookStoreDAO {
	private static final String INSERT_BOOK="INSERT INTO BOOK_STORE VALUES(BOOK_SEQ.NEXTVAL,:BOOKNAME,:PRICE,:PUBLISHER,:CATEGORY,:STATUS,:AUTHOR)";
	private static final String GET_BOOK_BY_AUTHOR="SELECT BOOKID,BOOKNAME,PRICE,PUBLISHER,CATEGORY,STATUS,AUTHOR FROM BOOK_STORE WHERE AUTHOR IN(:AUTH1,:AUTH2,:AUTH3) ORDER BY BOOKID";
	@Autowired
	NamedParameterJdbcTemplate template=null;
	@Override
	public int insertBook(BookBO bo) {
		MapSqlParameterSource source=null;
		int count=0;
		
		source=new MapSqlParameterSource();
		source.addValue("BOOKNAME", bo.getBookName());
		source.addValue("PRICE", bo.getPrice());
		source.addValue("PUBLISHER", bo.getPublisher());
		source.addValue("CATEGORY", bo.getCategory());
		source.addValue("STATUS", bo.getAvailabilityStatus());
		source.addValue("AUTHOR", bo.getAuthor());
		count=template.update(INSERT_BOOK, source);
		return count;
	}
	@Override
	public List<BookBO> getBookByAuthor(String author1, String author2, String author3) {
		List<BookBO> listbo=null;
		Map<String,Object> params=null;
		
		params=new HashMap();
		params.put("AUTH1", author1);
		params.put("AUTH2", author2);
		params.put("AUTH3", author3);
		listbo=template.query(GET_BOOK_BY_AUTHOR,params,
															rs->{
																List<BookBO> listbo1=null;
																BookBO bo=null;
																listbo1=new ArrayList<BookBO>();
																while(rs.next()) {
																bo=new BookBO();
																bo.setBookId(rs.getInt(1));
																bo.setBookName(rs.getString(2));
																bo.setPrice(rs.getFloat(3));
																bo.setPublisher(rs.getString(4));
																bo.setCategory(rs.getString(5));
																bo.setAvailabilityStatus(rs.getString(6));
																bo.setAuthor(rs.getString(7));
																listbo1.add(bo);
																}
																return  listbo1;
															});
		return listbo;
	}

}
