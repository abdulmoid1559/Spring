package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.PassengerBO;
import com.vd.dao.ReservationDAO;
import com.vd.dto.PassengerDTO;

@Service("resservice")
public class RailwayReservationServiceImpl implements RailwayReservationService {
	@Autowired
	ReservationDAO dao=null;

	@Override
	public String groupReservation(final List<PassengerDTO> listDTO) {
		final List<PassengerBO> listbo;
		String result=null;
		int [] res=null;
		listbo=new ArrayList();
		listDTO.forEach(dto->{
			PassengerBO bo= new PassengerBO();
//			BeanUtils.copyProperties(dto, bo);
			bo.setPassengerName(dto.getPassengerName());
			bo.setDestPlace(dto.getDestPlace());
			bo.setGender(dto.getGender());
			bo.setPrice(dto.getPrice());
			bo.setSrcPlace(dto.getSrcPlace());
			listbo.add(bo);
			
		});
		res=dao.groupReservation(listbo);
		if(res!=null) {
			result="these people"+res+"Reservation Succeded";
		}
		else {
			result="Reservation failed";
		}
		return result;
	}

}
