package com.vd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDTO {
	private int modelNo;
	private String name;
	private float price;
	private int gstRate;
}
