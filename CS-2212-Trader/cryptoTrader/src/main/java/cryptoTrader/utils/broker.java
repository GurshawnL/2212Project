package cryptoTrader.utils;

import java.util.Arrays;

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
	
	//returns length/number of brokers 
	public int getLength() {
		return this.len;
	}

	public static void main(String[] args) {
		String[] newNames = {"Hello", "ETC"};
		broker brokerObj = new broker();
		brokerObj.addBroker("trader-1", newNames, "Strat-1");
		brokerObj.getBroker(0);
	}

}
