package me.sreekanth.test;

public class Eaccounts {
	private long accountnumber;
	private String firstname, lastname;
	private int id, balance;
	public Eaccounts(int id, long accountnumber, String firstname, String lastname, int balance){
		this.id = id;
		this.accountnumber = accountnumber;
		this.firstname 	= firstname;
		this.lastname = lastname;
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public int getBalance() {
		return balance;
	}
	
}
