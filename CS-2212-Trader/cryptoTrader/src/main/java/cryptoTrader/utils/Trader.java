package cryptoTrader.utils;

import java.util.Arrays;

public class Trader {
	
	//conditions to be met
	private String[][] StratConditions = 
			{{"BTC", ">", "57000", "ETH", "<", "4350"},
			{"LTC", ">", "158", "DOGE", "<", "0.185"},
			{"SOL","<","125","ETH",">","160"},
			{"ADA","<","1.48","DOGE",">","0.19"}};
	
	//actions if conditions are met
	private String[][] StratActions = 
		{{"buy", "2", "ETH"},
		{"buy", "10", "DOGE"},
		{"sell", "5", "SOL"},
		{"sell", "25", "ADA"}};
	
	private String[][] trades;
	
	public Trader() {
		
		trades = new String[10][7];
		
	}
	
	public boolean checkStrat(int strat, String[] coins, Double[] prices) {
		
		String[] checkStrat = StratConditions[strat];
		
		Double checkPrice1 = Double.parseDouble(checkStrat[2]);
		Double checkPrice2 = Double.parseDouble(checkStrat[5]);
		
		String cond1 = checkStrat[1];
		String cond2 = checkStrat[4];
		
		//search the coin array for the wanted coin
		for(int i=0; i<coins.length; i++) {
			if (checkStrat[0].equals(coins[i])){ //coin1 is found
				//check price of coin1
				Double price1 = prices[i];
				//compare price of coin1 to condition
				if(cond1.equals(">")) {
					
				
					if(price1 > checkPrice1) { //if condition 1 is met, check price 2
						for(int j=0; j<coins.length; j++) {
							if (checkStrat[0].equals(coins[j])){ //coin2 is found
								//check price of coin2
								Double price2 = prices[j];
								
								if(cond2.equals("<")) { //if both conditions are true, return true
									if(price2>checkPrice2) {
										return true;
									}
								}	
					}
				}
				
			}
		}		
				
				else if (cond1.equals("<")) {
					if(price1 < checkPrice1) { //if condition 1 is met, check price 2
						for(int j=0; j<coins.length; j++) {
							if (checkStrat[0].equals(coins[j])){ //coin2 is found
								//check price of coin2
								Double price2 = prices[j];
								
								if(cond2.equals(">")){ //if both conditions are true, return true
									if(price2<checkPrice2) {
										return true;
									}
								}	
					}
				}
				
			}
				}
		
			}
		
		}
		return false;
		
	}
	
	//perform trade is coins exist
	public void performTrade(String traderName, int strat, String[] coins, Double[] prices, String date) {
		
		if (checkStrat(strat, coins, prices)) {
			String[] NewTrade = StratActions[strat];
			
			int index = indexOfCoin(NewTrade[2], coins);
			String StrStrat = changeNumbertoStrat(strat);
			
			String[] NewTradeLog = {traderName, StrStrat, NewTrade[2], NewTrade[0].toUpperCase(), NewTrade[1], Double.toString(prices[index]), date};
			System.out.println(Arrays.toString(NewTradeLog));
		} else {
			System.out.println("Error, the coin does not exist in the list");
		}
	}

	//finds index of coin in string
	public int indexOfCoin (String CoinName, String[] CoinList) {
		for (int i = 0; i < CoinList.length; i++) {
			if (CoinName.equals(CoinList[i])) {
				return i;
			}
		}
		return -1;		
	}
	
	//Changing Number to String for Strategy Literal
	public String changeNumbertoStrat (int strat) {
		if (strat == 0) {
			return "Strategy-A";
		} else if (strat == 1) {
			return "Strategy-B";
		} else if (strat == 2) {
			return "Strategy-C";
		} else if (strat == 3) {
			return "Strategy-D";
		} else {
			return null;
		}
	}
	
	//take group of brokers and perform trades for each broker
	public void performTradesGroup (String[] brokers, String[][] brokerCoins, String[] strategies, int numBrokers, String[] allCoins, Double[] allPrices, String date) {
		String[] newCoinArr = new String[10];
		Double[] newCoinPriceArr = new Double[10];
		int newArrLen = 0;
		
		
		for (int i = 0; i < numBrokers; i++) {
			int strategy = -1;
			if (strategies[i].equals("Strategy-A")) {
				strategy = 0;
			} else if (strategies[i].equals("Strategy-B")) {
				strategy = 1;
			} else if (strategies[i].equals("Strategy-C")) {
				strategy = 2;
			} else if (strategies[i].equals("Strategy-D")) {
				strategy = 3;
			}
			
			String[] setOfCoins = brokerCoins[i];
			for (int j = 0; j < allCoins.length; j++) {
				for (String coin : setOfCoins) {			
					if (coin.equals(allCoins[j])) {
						newCoinArr[newArrLen] = allCoins[j];
						newCoinPriceArr[newArrLen] = allPrices[j];
						newArrLen++;
					}
				}
			}
			
			System.out.println(Arrays.toString(newCoinArr));
			System.out.println(Arrays.toString(newCoinPriceArr));
			
			//performTrade(brokers[i], strategy, allCoins, allPrices, date);
		}
	}
	
	public static void main(String[] args) {
		
		String[] coins = {"BTC", "ETH"};
		Double[] prices = {58000.000000, 4000.00000};
		
		Trader traderObj = new Trader();
		traderObj.performTrade("Trader-1", 0, coins, prices, "04-04-2022");

	}

}
