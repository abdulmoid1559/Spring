package com.vd.bo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookBO {
	private int bookId=0;
	private String bookName=null;
	private float price=0.0f;
	private String publisher=null;
	private String author=null;
	private String Category=null;
	private String availabilityStatus=null;
}
