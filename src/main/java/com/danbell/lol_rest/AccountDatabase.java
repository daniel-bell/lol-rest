package com.danbell.lol_rest;

import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class AccountDatabase {

	private HashMap<String, LolAccount> lolAccounts;

	public AccountDatabase(){
		lolAccounts = new HashMap<String, LolAccount>();
	}
}