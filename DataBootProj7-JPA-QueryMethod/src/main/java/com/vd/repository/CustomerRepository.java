package com.vd.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vd.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
//	@Query("FROM Customer WHERE billAmt>?1 and billAmt<?2")
//	public List<Customer> getCustomerByBillRange(Double low,Double high);
//	@Query("FROM Customer WHERE billAmt>? and billAmt<?")
//	public List<Customer> getCustomerByBillRange(Double low,Double high);
//	@Query("FROM Customer WHERE address IN(:city1,:city2)")
//	public List<Customer> getCustomerByCity(@Param("city1")String city1,
//																				@Param("city2")String city2);
//	@Query("SELECT cno,cname,billAmt FROM Customer WHERE address IN(:city1,:city2)")
//	public List<Object[]> getCustomerDataByCity(@Param("city1")String city1,
//																				@Param("city2")String city2);
//	@Query("SELECT cname FROM Customer WHERE address IN(:city1,:city2)")
//	public List<String> getCustomerNameByCity(@Param("city1")String city1,
//																				@Param("city2")String city2);
	//----------------------------------------------Single row select Operation-----------------------------------
//	@Query("FROM Customer WHERE cname=:name")
//	public Customer getCustomerDetailByName(String name);
//	@Query("SELECT cname,address,billAmt FROM Customer WHERE cno=:no")
//	public Object[] getValuesOfCustomerByCno(Integer no);
/*
 * @Query("SELECT cname,address,billAmt FROM Customer WHERE cno=:no") public
 * List<Object[]> getValuesOfCustomerByCno(Integer no);
 * 
 * @Query("SELECT cname FROM Customer WHERE billAmt=:amt ") public String
 * getCustomerNameByBillAmt(Double amt);
 * //------------------------------Aggregate function
 * 
 * @Query("SELECT count(*),max(billAmt),avg(billAmt) from Customer") public
 * List<Object[]> getSum_MaxAndCount();
 */
	//----------------------Native SQL Query
	@Query(nativeQuery = true,value="select sysdate() from dual")
	public Date getSystemDate();
//	@Query(nativeQuery = true,value="select * from Customer where Address=?")
//	@Query(nativeQuery = true,value="select * from Customer where Address=?1")
	@Query(nativeQuery = true,value="select * from Customer where Address=:City")
	public Iterable<Customer> getCustomerByAddrs(String City);
	//-------------------------procedure call using native sql query 
	@Query(nativeQuery=true, value= "{CALL GET_CUSTOMER_BY_ADDRESS(?)}")
	public Iterable<Customer> getRecordByAddress(String addr);
}
