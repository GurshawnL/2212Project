package cryptoTrader.utils;

public class Trader {
	
	String[][] StratConditions;
	String[][] StratActions;
	
	String[][] trades;
	
	public Trader() {
		StratConditions = new String[4][6];
		StratActions = new String[4][3];
		
		trades = new String[10][7];
	}
	
	public boolean checKStrat(String strat) {
		return false;		
	}
	
	public void performTrade() {
		
	}

	public static void main(String[] args) {

	}

}
