package com.vd.dao;

import java.util.List;

import com.vd.bo.PassengerBO;

public interface ReservationDAO {
	public int[] groupReservation(List<PassengerBO> listBO);
}
