package com.vd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vd.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	interface ResultView1{
		public Integer getCno();
		public String getCname();
	}
	interface ResultView2{
		public Integer getCno();
		public String getCname();
		public Double getBillAmt();
	}
	//public List<ResultView1> findByAddress(String addrs);
	//public List<ResultView2> findByAddress(String addrs);
	
	//-----------------------------------Dynamic Projection ---------------------------------------------------------
	public <T>List<T> findByCno(Class<T> clazz,Integer cno);
}
