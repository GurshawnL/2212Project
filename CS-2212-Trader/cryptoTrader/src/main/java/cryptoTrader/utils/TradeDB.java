package cryptoTrader.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TradeDB {
	//file name
	private String DB_FILENAME = "trades_db.txt";
	File myObj;
	
	//constructor
	public TradeDB() {
		try { //try making new file
			myObj = new File(DB_FILENAME);
			if (myObj.createNewFile()) {
				System.out.println("Created New File: " + myObj.getName());
			} else {
				System.out.println("File Already Exists!");
			}
		} catch (IOException e) {
			System.out.println("There was an Error while making the file");		
		}
	}
	
	//write data to the txt file
	public void writeData (String[] trade) {
		try {
			FileWriter fileWriter = new FileWriter(DB_FILENAME);
			PrintWriter writerObj = new PrintWriter(fileWriter);
			System.out.println(Arrays.toString(trade));
			writerObj.print(Arrays.toString(trade));
			writerObj.close();
		} catch (IOException e) {
			System.out.println("There was an Error while making the file");		
		}
	}
	

	public static void main(String[] args) {
		
		TradeDB traderDB = new TradeDB();

	}

}
