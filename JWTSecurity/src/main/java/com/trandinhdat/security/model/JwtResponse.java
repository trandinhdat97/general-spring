package com.trandinhdat.security.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class JwtResponse implements Serializable{

	private static final long serialVersionUID = 6507237228337715869L;
	
	private final String jwttoken;
}
