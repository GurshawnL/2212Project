package cryptoTrader.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TradeDB {
	//file name
	private String DB_FILENAME = "trades_db.txt";
	private File myObj;
	private boolean firstWrite;
	
	//constructor
	public TradeDB() {
		firstWrite = false;
		try { //try making new file
			myObj = new File(DB_FILENAME);
			if (myObj.createNewFile()) {
				System.out.println("Created New File: " + myObj.getName());
				firstWrite = true;
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
			FileWriter fileWriter = new FileWriter(DB_FILENAME, true);
			PrintWriter writerObj = new PrintWriter(fileWriter);
			//System.out.println(Arrays.toString(trade));
			
			if (!firstWrite) {
				writerObj.print("\n"+Arrays.toString(trade));				
			} else {
				writerObj.print(Arrays.toString(trade));
			}
			
			writerObj.close();
		} catch (IOException e) {
			System.out.println("There was an Error while reading the file");		
		}
	}
	
	public Object[][] getData() {
		Object[][] data = new Object[1000][7];
		int objLen = 0;
		try {
			File dbFile = new File(DB_FILENAME);
			Scanner sc = new Scanner(dbFile);
			
			
			
			while (sc.hasNextLine()) {
				String dataLine = sc.nextLine();
				dataLine = dataLine.substring(1, dataLine.length()-1);
				dataLine = dataLine.replaceAll("\\s","");
				String[] dataLineArr = dataLine.split(",");
				for (int j = 0; j < dataLineArr.length; j++) {
					data[objLen][j] = dataLineArr[j];					
				}
				objLen++;
												
			}
			
			data = Arrays.copyOfRange(data, 0, objLen);
						
		} catch (FileNotFoundException e) {
			System.out.println("There was an Error reading making the file");	
		}	
		
		return data;
	}
	

	public static void main(String[] args) {
		
		TradeDB traderDB = new TradeDB();
		traderDB.getData();

	}

}
