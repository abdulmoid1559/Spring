package com.vd.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountBO{
	private String userName;
	private String password;
}
