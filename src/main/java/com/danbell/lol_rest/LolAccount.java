package com.danbell.lol_rest;

public class LolAccount{
	
	private String username;
	private String password;
	private String region;

	public LolAccount(String username, String password, String region){
		this.username = username;
		this.password = password;
		this.region = region;
	}
}