package com.vd.service;

import java.util.List;

import com.vd.dto.PassengerDTO;

public interface RailwayReservationService {
	public String groupReservation(List<PassengerDTO> listDTO);
}
