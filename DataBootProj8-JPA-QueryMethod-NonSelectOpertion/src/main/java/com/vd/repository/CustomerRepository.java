package com.vd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vd.entity.Customer;
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	//-----------------------------bulk row update operation
//	@Modifying
//	@Query("UPDATE Customer SET  billAmt=billAmt+ :amt WHERE address=:city1")
//	public Integer updateBillAmtByCity(String city1,Double amt);
	//-----------------single row update Option---------------------------------
	/*
	 * @Modifying
	 * 
	 * @Query("UPDATE Customer SET  address=:city1 WHERE cno=:cno") public Integer
	 * updateAddressByCustNo(String city1,Integer cno);
	 * //--------------------------bulk delete operation
	 * 
	 * @Modifying
	 * 
	 * @Query("DELETE Customer WHERE address=:city") public Integer
	 * deleteRowByCity(String city); //----------------------------Single row delete
	 * Operation -----------------------
	 * 
	 * @Modifying
	 * 
	 * @Query("DELETE Customer WHERE cno=:cno") public Integer
	 * deleteRowByCno(Integer cno);
	 */
	@Modifying
	@Query(nativeQuery = true,value="INSERT INTO CUSTOMER VALUES(HIBERNATE_SEQUENCE.NEXTVAL,?,?,?)")
	public Integer insertRecord(String addrs,Double billAmt,String name);
}
