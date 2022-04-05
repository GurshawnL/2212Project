package cryptoTrader.utils;

import java.util.Arrays;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class broker { //create a broker object to deal with brokers
	
	//list of brokers
	private String [] names;
	private String [][] coins;
	private String [] strategies; 
	private int len; //number of brokers
	
	//Constants
	private int MAX = 1000;
	private int coinMAX = 10;
	
	//Constructors
	public broker () { 
		names = new String[MAX];
		coins = new String[MAX][coinMAX];
		strategies = new String[MAX];
		len = 0;
	}
	
	//add a new broker
	public void addBroker (String name, String[] coinList, String strat) {
		names[len] = name;
		coins[len] = coinList;
		strategies[len] = strat;
		len++;
	}
	
	//print broker in console
	public void getBroker (int id) {
		System.out.println(names[id] + " " + Arrays.toString(coins[id]) + " " + strategies[id]);
	}
	
	//get list of brokers
	public String[] getBrokers () {
		return this.names;
	}
	
	//get strats
	public String[] getStrats() {
		return this.strategies;
	}
	
	//returns length/number of brokers 
	public int getLength() {
		return this.len;
	}
	
	//return the list of coins
	public String[][] getCoins() {
		return this.coins;		
	}
	
	//return a list of coins with no repeats
	public String[] getListOfCoins() {
		String[] allCoins = new String[coinMAX];
		int lenAllCoins = 0;
		
		for (String[] list : coins) {
			for (String item : list) {
				if (item != null) {
					
					boolean itemExists = false;
					
					for (String coins: allCoins) {
						if (item.equals(coins)) {
							itemExists = true;
						}
					}
					
					if (!itemExists) {
						allCoins[lenAllCoins] = item;
						lenAllCoins++;
					}
					
				}
				
			}
		}
		
		return allCoins;
	}
	
	//return the coin max 
	public int getCoinMax() {
		return this.coinMAX;
	}
	
	//index of first null
	public int getFirstNull(String[] coinList) {
		int index = 0;
		for (int i = 0; i < getCoinMax(); i++) {
			if (coinList[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public String[] getSubArray(String[] coinList, int firstNull) {
		String[] cleanArray = null;
		
		if (firstNull != -1) {
			cleanArray = Arrays.copyOfRange(coinList, 0, firstNull);
		}
		
		return cleanArray;
	}
	
	//get data in dd/mm/yyyy format
	public String getDateToday() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String DateToday = simpleDate.format(date);
		DateToday = DateToday.replace('/', '-');
		return DateToday;
	}

	public static void main(String[] args) {
		String[] newNames = {"Hello", "ETC", "ADA"};
		String[] newNames2 = {"BTC", "ETC", "LTC", "ADA"};
		broker brokerObj = new broker();
		/*
		brokerObj.addBroker("trader-1", newNames, "Strat-1");
		brokerObj.addBroker("trader-1", newNames2, "Strat-1");
		String [] list = brokerObj.getListOfCoins();
		System.out.println(Arrays.toString(list));
		
		System.out.println(brokerObj.getDateToday());
		
		*/		
	}

}
