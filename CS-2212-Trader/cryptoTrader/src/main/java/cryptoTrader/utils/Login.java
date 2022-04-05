package cryptoTrader.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	private String DB_FILENAME = "login_db.txt";
	private String username, password;
	private HashMap<String, String> loginData;
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
		this.loginData = new HashMap<String, String>();
		
		File dbFile = new File(DB_FILENAME);
		try {
			if (!dbFile.exists()) {
				dbFile.createNewFile();
			}
			Scanner sc = new Scanner(dbFile);
			
			while (sc.hasNextLine()) {
				String dataLine = sc.nextLine();
				String dataUsername = dataLine.split(":")[0];
				String dataPass = dataLine.split(":")[1];
				
				loginData.put(dataUsername, dataPass);
			}
			
			
		} catch (IOException error) {
			System.out.println("Login database file not found.");
		}
	}
	
	public boolean attempt() {
		if (this.loginData.get(this.username) != null) {
			if (this.loginData.get(this.username).equals(this.password)) {
				return true;
			}
		}
		
		return false;
	}
	
}
