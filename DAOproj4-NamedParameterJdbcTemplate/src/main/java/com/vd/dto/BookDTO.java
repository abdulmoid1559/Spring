package com.vd.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

public class BookDTO implements Serializable {
	private int bookId=0;
	private String bookName=null;
	private float price=0.0f;
	private String publisher=null;
	private String author=null;
	private String Category=null;
	private String availabilityStatus=null;
	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", publisher=" + publisher
				+ ", author=" + author + ", Category=" + Category + ", availabilityStatus=" + availabilityStatus + "]";
	}
}
