package cryptoTrader.utils;

public class Trader {
	
	String[][] StratConditions = 
			{{"BTC", ">", "57000", "ETH", "<", "4350"},
			{"LTC", ">", "158", "DOGE", "<", "0.185"},
			{"SOL","<","125","ETH",">","160"},
			{"ADA","<","1.48","DOGE",">","0.19"}};
	
	String[][] StratActions = 
		{{"buy", "2", "ETH"},
		{"buy", "10", "DOGE"},
		{"sell", "5", "SOL"},
		{"sell", "25", "ADA"}};
	
	String[][] trades;
	
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
								
								if(cond2.equals(">")) { //if both conditions are true, return true
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
								
								if(cond2.equals("<")) { //if both conditions are true, return true
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
	
	public void performTrade(String traderName, int strat, String[] coins, Double[] prices, String date) {
		
		if (checkStrat(strat, coins, prices)) {
			String[] NewTrade = StratActions[strat];
			System.out.print(NewTrade[0] + " " + NewTrade[1] + " " + NewTrade[2]);			
			String[] NewTradeLog = {traderName, Integer.toString(strat), NewTrade[0], NewTrade[1], NewTrade[2], Double.toString(prices[0]), date};
		}
	}

	public static void main(String[] args) {
		
		String[] coins = {"BTC", "ETH"};
		Double[] prices = {58000.000000, 4000.00000};
		
		Trader traderObj = new Trader();
		boolean val = traderObj.checkStrat(0, coins, prices);
		if (val) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}

	}

}
