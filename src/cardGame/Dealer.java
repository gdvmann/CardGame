package cardGame;

public final class Dealer {
	
	private final int dealerIndex;
	private final int dealerScore;
	private final Deck dealerDeck;
	
	public int getDealerIndex() {
		return dealerIndex;
	}
	public int getDealerScore() {
		return dealerScore;
	}
	public Deck getDealerDeck() {
		return dealerDeck;
	}
	
	public Dealer(Deck dealerDeck, int dealerScore, int dealerIndex){
		
		this.dealerDeck = dealerDeck;
		this.dealerScore = dealerScore;
		this.dealerIndex = dealerIndex;
		
	}

}
