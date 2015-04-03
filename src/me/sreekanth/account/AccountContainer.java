package me.sreekanth.account;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class AccountContainer {

	private static final String ACCOUNT_FILE = "account.txt";
	private HashMap map = new HashMap();
	
	public void addAccount(Account account) {
		map.put(account.getAccNo(), account);
	}
	
	public Account getAccount(int accNo) {
		return (Account) map.get(accNo);
	}

	public void printAllAccounts() {
		Collection accounts = map.values();
		Iterator iterator = accounts.iterator();
		while( iterator.hasNext() ) {
			Account account = (Account) iterator.next();
			System.out.println("[accountNumber=" + account.getAccNo() 
					+ ", balance=" + account.getBalance() + "]");
		}
	}
	
	public void save() throws IOException {
		
		FileOutputStream os = new FileOutputStream(ACCOUNT_FILE);
		DataOutputStream dos = new DataOutputStream(os);
		Collection accounts = map.values();
		Iterator iterator = accounts.iterator();
		while( iterator.hasNext() ) {
			Account account = (Account) iterator.next();
			dos.writeInt(account.getAccNo());
			dos.writeInt(account.getBalance());
		}
		
		dos.close();
		os.close();
	}

	public void read() throws IOException {
		
		FileInputStream is = new FileInputStream(ACCOUNT_FILE);
		DataInputStream dis = new DataInputStream(is);

		int accountNumber = -1;
		
		try {
			while( (accountNumber = dis.readInt()) != -1 ) {
				int balance = dis.readInt();
				
				Account account = new Account(accountNumber, balance);
				addAccount(account);
			}
		} catch(EOFException e) {
			//
		}
		dis.close();
		is.close();
		
	}
	
}
