package com.vd.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BookInfo")
@Data
public class BookBO {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "BOOK_ID_SEQ",initialValue = 1010,allocationSize =1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer bid;
	@Column(name="BOOKNAME",length=20)
	private String bookName;
	@Column(name="AUTHORNAME",length=20)
	private String authorName;
	@Column(name="PRICE",length=20)
	private Double price;
	@Column(name="DESCRIPTION",length=200)
	private String description;
	@Column(name="STATUS")
	private Boolean avbStatus;
	@Column(name="IMAGENAME")
	private String imgName;
	@Column(name="DISCOUNT")
	private Integer discount;
	
}
