package cardGame;

import java.util.Scanner;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// Variables
		
		@SuppressWarnings("resource")			
		Scanner input = new Scanner(System.in);
		
		Deck deck = new Deck();
		Deck playerDeck = new Deck();
		Deck dealerDeck = new Deck();
		
		
		deck.setDeck();
		
		int currentMoney = 500;
		char decision;
		boolean back = false;
		char dec;
		
		boolean stop = false;
		
		
		startPrompt();
		
		
		while (stop == false){
		
		
		
		// prompt(currentMoney);
		
		
		
		decision = input.next().charAt(0);
		
		if(decision == 'y'){
			
			if(currentMoney > 0){
			currentMoney = game(deck, playerDeck, dealerDeck, currentMoney);
			prompt(currentMoney);
			}
			else{
				stop = true;
				System.out.println("Sorry You Don't Have Enough Money, Thank You Come Again");
			}
			
		}
		else if(decision == 'n'){
			
			
			
			stop = true;
			System.out.println("Thank you for playing, Good Bye.");
			
		}
		else if(decision == 'a'){
			admin();
			while(back == false){
				dec = input.next().charAt(0);
				
				if(dec == 'n'){
					
					System.out.println("There are this many cards :" + deck.deckSize() + "\n");
					
				}
				else if(dec == 'c'){
					
					deck.clearDeck();
					System.out.println("Deck has been cleared\n");
					
				}
				else if(dec == 's'){
					
					deck.setDeck();
					System.out.println("You set the deck\n");
					
				}
				else if(dec == 'd'){
					
					deck.showCard(0);
					
				}
				else if(dec == 'f'){
					
					deck.shuffleDeck();
					System.out.println("Deck has been shuffled\n");
					
				}
				else if(dec == 'v'){
					
					if(deck.aceCheck(0)){
						System.out.println("This is an ace\n");
					}
					else{
						System.out.println("This is not an ace\n");
					}
					
				}
				else if(dec == 'k'){
					
					deck.dealCard(playerDeck);
					System.out.println("Dealt card to player\n");					
				}
				else if(dec == 'j'){
					
					if(playerDeck.isEmpty()){
						System.out.println("Player deck is empty\n");
					}
					else if(playerDeck.deckSize() > 1){
						
						System.out.println("Player has these in deck: \n");
						for(int i = 0; i <playerDeck.deckSize(); i++){
						playerDeck.showCard(i);
						}
					}
					else {
						playerDeck.showCard(0);
						
					}
					
				}
				
				else if(dec == 'b'){
					
					back = true;
					startPrompt();
					
				}
				
				}
			
			
		}
		
		
		
		} // while loop
	} // main
	
	
	private static void startPrompt(){
		System.out.println("Welcome to a game of Black Jack");
		System.out.println("All Players start with $500");
		System.out.println("Ready to play?");
		System.out.println("Type y for Yes or n for No\n");
		
		
	}
	
	private static void admin(){
		System.out.println("This is Admin Controls");
		System.out.println("What would you like to do?");
		System.out.println("Type n for current deck size");
		System.out.println("Type d to show top card");
		System.out.println("Type c to clear the deck");
		System.out.println("Type s to set the deck");
		System.out.println("Type f to shuffle the deck");
		System.out.println("Type v to do an ace check");
		System.out.println("Type k to deal card to player");
		System.out.println("Type j to show player's card");
		System.out.println("Type b to go back\n");
		
	}
	
	private static void prompt(int money){
		System.out.println("You Currently have $" + money + "\n");
		System.out.println("Would you like to continue this game?");
		System.out.println("Enter y for yes and n for no");
		System.out.println("\n");
		
	}
	
	private static int game(Deck deck, Deck playerDeck, Deck dealerDeck, int money){
		@SuppressWarnings("resource")			
		Scanner input = new Scanner(System.in);
		
		deck.setDeck();
		playerDeck.clearDeck();
		dealerDeck.clearDeck();
		
		int playerScore = 0;
		int dealerScore = 0;
		boolean play = true;
		char draw;
		int playerIndex = 0;	// counter for where you are in playerDeck
		int dealerIndex = 0;	// counter for where you are in dealerDeck
		
		System.out.println("How much would you like to bet?");
		
		int bet = input.nextInt();
		
		while(bet > money){
			
			System.out.println("Sorry you don't have enough money, please choose a lower bet");
			bet = input.nextInt();
		}
		money = money - bet;
		
		System.out.println("Thank you, you have chosen to bet: $" + bet + "\n");
		
		
		
		deck.deleteCard(0); // Sacrifice top card
		
		deck.dealCard(playerDeck);
		System.out.println("You were dealt \n");
		playerDeck.showCard(playerIndex);
		if(playerDeck.aceCheck(playerIndex)){
			
			System.out.println("You were dealt an Ace, would you like it to be a 1 or 10?");
			playerScore = playerScore + input.nextInt();
			
		}
		else
		{
			playerScore = playerScore + playerDeck.cardValue(playerIndex);
		}
		playerIndex++;
		
		deck.dealCard(dealerDeck);
		System.out.println("Dealer was dealt \n");
		dealerDeck.showCard(dealerIndex);
		dealerScore = dealerDeck.cardValue(dealerIndex); // doesn't matter if there's an ace on the first hand just leave it a 10
		dealerIndex++;
		
		//System.out.println("Press any key to continue \n");  // stop gap
		input.nextLine();
		
		deck.dealCard(playerDeck);
		System.out.println("You were dealt \n");
		playerDeck.showCard(playerIndex);
		if(playerDeck.aceCheck(playerIndex)){
			
			System.out.println("You were dealt an Ace, would you like it to be a 1 or 10?");
			playerScore = playerScore + input.nextInt();
			
		}
		else
		{
			playerScore = playerScore + playerDeck.cardValue(playerIndex);
		}
		playerIndex++;
		
		deck.dealCard(dealerDeck);
		System.out.println("Dealer was dealt a card face down\n");
		if(dealerDeck.aceCheck(dealerIndex)){
			dealerScore = dealerScore + 1; // 2nd hand lets make it always a 1 
		}
		else
		{
			dealerScore = dealerScore + dealerDeck.cardValue(dealerIndex);
		}
		dealerIndex++;
		
		System.out.println("Press any key to continue \n");  // stop gap
		input.nextLine();
		
		System.out.println("Dealer currently has: \n");
		dealerDeck.showCard(0);
		
		System.out.println("Player currently has: " + playerScore + "\n");
		for(int i = 0; i <playerDeck.deckSize(); i++){
		playerDeck.showCard(i);
		}
		
		
		// **************************************************************************
		
		
		while(play == true){
		
		System.out.println("Type s to stay or d to draw another card");
		
		draw = input.next().charAt(0);
		if(draw == 'd'){
			
			deck.dealCard(playerDeck);
			System.out.println("You were dealt \n");
			playerDeck.showCard(playerIndex);
			if(playerDeck.aceCheck(playerIndex)){
				
				System.out.println("You were dealt an Ace, would you like it to be a 1 or 10?");
				playerScore = playerScore + input.nextInt();
				
			}
			else
			{
				playerScore = playerScore + playerDeck.cardValue(playerIndex);
			}
			playerIndex++;
			
			
			System.out.println("Press any key to continue \n");  // stop gap
			input.nextLine();
			
			System.out.println("Dealer currently has: \n");
			dealerDeck.showCard(0);
			
			System.out.println("Player currently has: " + playerScore + "\n");
			for(int i = 0; i <playerDeck.deckSize(); i++){
			playerDeck.showCard(i);
			}
			if(playerScore > 21){
				
				System.out.println("Sorry you went over 21, you lose. \n");
				play = false;
				
			}
			
			
		}
		else if(draw == 's'){
				
			while(dealerScore < 16){  // dealer always stands at 16 and dealer can see player's score so no need to go over their score
				System.out.println("Dealer currently has: " + dealerScore + "\n");
				for(int i = 0; i <dealerDeck.deckSize(); i++){
				dealerDeck.showCard(i);
				}
				
				
				
				deck.dealCard(dealerDeck);
				System.out.println("Dealer draws  \n");
				dealerDeck.showCard(dealerIndex);
				if(dealerDeck.aceCheck(dealerIndex)){
					if(dealerScore > 12){
						dealerScore = dealerScore + 1;
					}
					
				}
				else{
				dealerScore = dealerScore + dealerDeck.cardValue(dealerIndex);
				}
				dealerIndex++;
				
			/*	if(dealerScore > 21){
					System.out.println("Congratulations you win " + bet);
					money = money + bet*2;
					play = false;
					
				}
				
				if(dealerScore > playerScore){
					System.out.println("Sorry you lose");
					play = false;
					
				} 
				
				*/
			}
			
			System.out.println("Dealer currently has: " + dealerScore + "\n");
			for(int i = 0; i <dealerDeck.deckSize(); i++){
			dealerDeck.showCard(i);
			}
			
			System.out.println("Player currently has: " + playerScore + "\n");
			for(int i = 0; i <playerDeck.deckSize(); i++){
			playerDeck.showCard(i);
			}
			
			if(playerScore > 21){
				System.out.println("Sorry you lose\n");
				play = false;
				
			}
			
			else if(dealerScore > 21){
				System.out.println("Congratulations you win " + bet + "\n");
				money = money + bet*2;
				play = false;
				
			}
			else if(playerScore == dealerScore){
				System.out.println("It was a tie, you get your bet back\n");
				money = money + bet;
				play = false;
			}
			
			else if(playerScore > dealerScore){
				
				System.out.println("Congratulations you win " + bet + "\n");
				money = money + bet*2;
				play = false;
				
			}
			else{
				System.out.println("Sorry you lose\n");
				play = false;
				
			}
			
		}
		
		} // while
		
		return money;
	}
	
	private static int playerTurn(Deck deck, Deck playerDeck, int playerScore, int index){
		@SuppressWarnings("resource")			
		Scanner input = new Scanner(System.in);
		
		deck.dealCard(playerDeck);
		System.out.println("You were dealt a \n");
		playerDeck.showCard(index);
		if(playerDeck.aceCheck(index)){
			
			System.out.println("You were dealt an Ace, would you like it to be a 1 or 10?");
			playerScore = playerScore + input.nextInt();
			
		}
		else
		{
			playerScore = playerScore + playerDeck.cardValue(index);
		}
		
		return playerScore;
	}

} // final
