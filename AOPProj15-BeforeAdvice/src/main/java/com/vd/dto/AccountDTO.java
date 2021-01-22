package com.vd.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO implements Serializable {
	private String userName;
	private String password;
}
