package com.vd.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PassengerDTO implements Serializable {
	private int pesid=0;
	private String passengerName=null;
	private String gender=null;
	private String srcPlace=null;
	private String destPlace=null;
	private float price=0.0f;
}
