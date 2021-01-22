package com.vd.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.vd.bo.PassengerBO;
@Repository("reserveDAO")
public class ReservationDAOImpl implements ReservationDAO {
	private final String INSERT_PASSENGER_QUERY="INSERT INTO RAILWAY_RESERVATION VALUES (RESR_SEQ.NEXTVAL,?,?,?,?,?)";
	@Autowired
	private JdbcTemplate template=null;
	@Override
	public int[] groupReservation(final List<PassengerBO> listBO) {
		int [] res=null;
		
		res=template.batchUpdate(INSERT_PASSENGER_QUERY,new BatchPreparedStatementSetter() {
																										@Override
																										public void setValues(PreparedStatement ps, int i) throws SQLException {
																											ps.setString(1, listBO.get(i).getPassengerName());
																											ps.setString(2, listBO.get(i).getGender());
																											ps.setString(3, listBO.get(i).getSrcPlace());
																											ps.setString(4, listBO.get(i).getDestPlace());
																											ps.setFloat(5, listBO.get(i).getPrice());
																										}
																										
																										@Override
																										public int getBatchSize() {											
																											return listBO.size();
																										}
		});
		return res;
	}

}
