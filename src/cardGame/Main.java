package cardGame;

import java.util.Scanner;
import java.util.Random;


public class Main {

	static Deck deck = new Deck();
	static Deck playerDeck = new Deck();
	static Deck dealerDeck = new Deck();
	static Deck splitDeck = new Deck();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// Variables
		
		@SuppressWarnings("resource")			
		Scanner input = new Scanner(System.in);
			
		int currentMoney = 500;
		char decision;
		boolean back = false;
		
		
		boolean stop = false;
		
		
		startPrompt();
		
		decision = input.next().charAt(0);
		while(decision != 'y' && decision != 'n' && decision !='p'){
			startPrompt();
			decision = input.next().charAt(0);
		}
		while (stop == false){
			
		if(decision == 'y'){
			char dec = decision;
			
			while(dec == 'y'){
				
			deck.setDeck();
			
			if(currentMoney > 0){
			currentMoney = game(currentMoney);
			prompt(currentMoney);
			dec = input.next().charAt(0);
			while(dec != 'y' && dec != 'n'){
				prompt(currentMoney);
				dec = input.next().charAt(0);
			}
			}
			else{
				stop = true;
				System.out.println("Sorry You Don't Have Enough Money, Thank You Come Again");
				input.nextLine();
			}
			}
			
			System.out.println("Thank you for playing, Good Bye.");
			input.nextLine();
			stop = true;
		
			
		}
		else if(decision == 'n'){
			
			
			
			stop = true;
			System.out.println("Thank you for playing, Good Bye.");
			input.nextLine();
			
		}
		else if(decision == 'p'){
			
			admin();
						
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
		
		@SuppressWarnings("resource")			
		Scanner input = new Scanner(System.in);
		
		char dec = input.next().charAt(0);
		
		if(dec == 'm'){
			
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
			
			return;
			
		}
	}
	
	private static void prompt(int money){
		System.out.println("You Currently have $" + money + "\n");
		System.out.println("Would you like to continue this game?\n");
		System.out.println("Enter y for yes and n for no");
		System.out.println("\n");
		
	}
	
	private static int game(int money){
		@SuppressWarnings("resource")			
		Scanner input = new Scanner(System.in);
		
		deck.setDeck();
		playerDeck.clearDeck();
		dealerDeck.clearDeck();
		
		Dealer dealer;
		
		int playerScore = 0;
		int dealerScore = 0;
		boolean play = true;
		char draw;
		int playerIndex = 0;	// counter for where you are in playerDeck
		int dealerIndex = 0;	// counter for where you are in dealerDeck
		char ch = 'q'; // initialized to q because q won't be used
		int bust = 0;
		
		boolean blackjack = false; // triggers if player gets a blackjack
		
		System.out.println("How much would you like to bet?\n");

		while(input.hasNextInt() == false){
			System.out.println("You must enter a number.\n");	
			System.out.println("How much would you like to bet?\n");		
			input.next();
		}
		int bet = input.nextInt();
		while(bet > money){
			
			System.out.println("Sorry you don't have enough money, please choose a lower bet\n");
			bet = input.nextInt();
		}
		money = money - bet;
		
		System.out.println("Thank you, you have chosen to bet: $" + bet + "\n");
		
		/*
		System.out.println("How much would you like to bust bet?\n");
		
		 bust = input.nextInt();
		
		while(bust > money){
			
			System.out.println("Sorry you don't have enough money, please choose a lower bet\n");
			bet = input.nextInt();
		}
		money = money - bust;
		
		System.out.println("Thank you, you have chosen a bust bet of: $" + bust + "\n");
		
		*/
		
		deck.deleteCard(0); // Sacrifice top card
		System.out.println("Top card was discarded\n");
		
		playerScore = dDraw(playerDeck, playerScore, playerIndex, input);
		playerIndex++;
		
		deck.dealCard(dealerDeck);
		System.out.println("Dealer was dealt \n");
		dealerDeck.showCard(dealerIndex);
		dealerScore = dealerDeck.cardValue(dealerIndex); // doesn't matter if there's an ace on the first hand just leave it a 10
		dealerIndex++;
		
		//System.out.println("Press any key to continue \n");  // stop gap
		input.nextLine();
		
		playerScore = dDraw(playerDeck, playerScore, playerIndex, input);
		playerIndex++;
		
		deck.dealCard(dealerDeck);
		System.out.println("Dealer was dealt a card face down\n");
		if(dealerDeck.aceCheck(dealerIndex)){
			if(dealerScore >= 11){
				dealerScore = dealerScore + 1;
			}
			else {
				dealerScore = dealerScore +11;
			} 
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
		
		print(playerDeck, playerScore, "Player");
			
		
		// **************************************************************************
		
		if(playerDeck.blackjackCheck() == true){
						
			System.out.println("Congratulations got a Blackjack and get 1.5x return on your bet");
			blackjack = true;
			input.nextLine();
			
		}
		else if(playerDeck.cardValue(0) == playerDeck.cardValue(1)){
			while(ch != 's' && ch != 'd' && ch != 'k' && ch != 'a' && ch != 'f'){
				System.out.println("You have drawn a pair, you get the option to split.");
				System.out.println("Type s to stay, d to draw another card, f to split your cards, "
						+ "a to double your bet, k to surrender and reclaim half your bet\n");
				ch = input.next().charAt(0);
			}
			
		}
		else if(playerScore >= 9 && playerScore <= 11){
			while(ch != 's' && ch != 'd' && ch != 'k' && ch != 'a'){
				System.out.println("You have a score between 9 and 11 you get the option to double down.");
				System.out.println("If you choose to double down you will only be dealt 1 more card");
				System.out.println("Type s to stay, d to draw another card, a to double down, k to surrender and reclaim half your bet\n");
				ch = input.next().charAt(0);
			}
			
		}
		else{
		while(ch != 's' && ch != 'd' && ch != 'k'){
			System.out.println("Type s to stay, d to draw another card, k to surrender and reclaim half your bet\n");
			ch = input.next().charAt(0);
		}
		}
		
		
		if(blackjack == true){
			draw = 's';
		}
		if(ch == 'f'){
			
			if(playerDeck.cardValue(0) == playerDeck.cardValue(1)){
			
			if(bet > money){

				while(ch == 'f'){
					System.out.println("Sorry you don't have enough money to do a split");
					System.out.println("Type s to stay or d to draw another card\n");
					ch = input.next().charAt(0);			
				}
				draw = ch;
			}
			
			else{
			money = money - bet;
			System.out.println("Thank you, $" + bet + " was taken from your money for the split\n");
			draw = 'f';
			}
			
			}
			else
			{
				while(ch == 'f'){
					System.out.println("Type s to stay, d to draw another card, k to surrender and reclaim half your bet\n");;
					ch = input.next().charAt(0);			
				}
				draw = ch;
			}
			
				
		}
		else if(ch == 'a'){
			
			if(playerScore >= 9 && playerScore <= 11){
			
			if(bet > money){ // don't have enough money to double down
				while(ch == 'a'){
					System.out.println("Sorry you don't have enough money to double your bet");
					System.out.println("Type s to stay, d to draw another card, k to surrender and reclaim half your bet\n");
					ch = input.next().charAt(0);			
				}
				draw = ch;
			}
			else{
			money = money - bet;
			bet = bet*2;
			System.out.println("Thank you, your bet is now $" + bet + "\n");
			
			draw = 'a';
			}
			
			}
			else
			{
				while(ch == 'a'){
					System.out.println("Type s to stay, d to draw another card, k to surrender and reclaim half your bet\n");;
					ch = input.next().charAt(0);			
				}
				draw = ch;
				
			}
		}
		
		else{
			draw = ch;
		}
		
		if(draw == 'k'){
			bet = bet/2;
			System.out.println("You have chosen to surrender. You will get back $" + bet + " of your bet");
			money = money + bet;
			play = false;
		}
		if(draw == 'a'){
			playerScore = dDraw(playerDeck, playerScore, playerIndex, input);
			playerIndex++;
			
			dealer = dealerResult(dealerDeck, dealerScore, dealerIndex, input);
			dealerScore = dealer.getDealerScore();
			dealerIndex = dealer.getDealerIndex();
			
			
			money = result(playerDeck, dealerDeck, playerScore, dealerScore, money, bet, bust, "Player", blackjack);
			
			play = false;
			
		}
		
		
		while(play == true){
		
		// System.out.println("Type s to stay or d to draw another card");
			
		
		if(draw == 'd'){
			
			playerScore = dDraw(playerDeck, playerScore, playerIndex, input);
			playerIndex++;
			
			
			System.out.println("Press any key to continue \n");  // stop gap
			input.nextLine();
			
			System.out.println("Dealer currently has: \n");
			dealerDeck.showCard(0);
			
			print(playerDeck, playerScore, "Player");
			
			if(playerScore > 21){
				
				System.out.println("Sorry you went over 21, you lose. \n");
				play = false;
				
			}
			else{
				System.out.println("Type s to stay or d to draw another card\n");
				draw = input.next().charAt(0);
				while(draw != 's' && draw != 'd'){
					System.out.println("Type s to stay or d to draw another card\n");	
					draw = input.next().charAt(0);
				}
			}
			
			
		}
		else if(draw == 's'){
				
			dealer = dealerResult(dealerDeck, dealerScore, dealerIndex, input);
			dealerScore = dealer.getDealerScore();
			dealerIndex = dealer.getDealerIndex();
			
			money = result(playerDeck, dealerDeck, playerScore, dealerScore, money, bet, bust, "Player", blackjack);
			play = false;
			
		}
		
		else if(draw == 'f'){
			
			int splitIndex = 0;
			int splitScore = 0;
			playerIndex = 0;
			char choice1 = 'd';
			char choice2 = 'd';
			boolean going = true;
			boolean blackjack2 = false;
			 			
			splitDeck.clearDeck();
			
			playerDeck.dealCard(splitDeck);
			splitIndex++; // because each deck has 1 card in it now
			playerIndex++;
			
			splitScore = splitDeck.cardValue(0); 
			playerScore = playerDeck.cardValue(0);
			
					
			System.out.println("You have split the deck\n");
			
			System.out.println("Dealer Currently has: \n" + dealerDeck.printCard(0) + "\n");
			
			print(playerDeck, playerScore, "Deck 1");
		
			print(splitDeck, splitScore, "Deck 2");
			
			playerScore = dDraw(playerDeck, playerScore, playerIndex, input);
			playerIndex++;
			
			splitScore = dDraw(splitDeck, splitScore, splitIndex, input);
			splitIndex++;
			
			if(playerDeck.blackjackCheck() == true){
				System.out.println("Congratulations got a Blackjack and get 1.5x return on your bet");
				blackjack = true;
				choice1 = 's';
			}
			
			if(splitDeck.blackjackCheck() == true){				
				System.out.println("Congratulations got a Blackjack and get 1.5x return on your bet");
				blackjack2 = true;
				choice2 = 's';
			}
			
			// ******************************************************************************
			
			while(going == true){
			
				System.out.println("Dealer Currently has: \n" + dealerDeck.printCard(0) + "\n");
				
				print(playerDeck, playerScore, "Deck 1");
			
				print(splitDeck, splitScore, "Deck 2");
				
				if(choice1 != 's' && playerScore <= 21){
										
					System.out.println("What would you like to do with Deck 1? Type s to stay, d to draw another card");
					
					choice1 = input.next().charAt(0);
					while(choice1 != 's' && choice1 != 'd'){
						System.out.println("What would you like to do with Deck 1? Type s to stay, d to draw another card");
						choice1 = input.next().charAt(0);
					}
					
					if(choice1 == 'd'){
						playerScore = dDraw(playerDeck, playerScore, playerIndex, input);
						playerIndex++;
											
					}
				}
				if(choice2 != 's' && splitScore <= 21){
					
					System.out.println("What would you like to do with Deck 2? Type s to stay, d to draw another card");
					
					choice2 = input.next().charAt(0);
					while(choice2 != 's' && choice2 != 'd'){
						System.out.println("What would you like to do with Deck 2? Type s to stay, d to draw another card");
						choice2 = input.next().charAt(0);
					}
					
					if(choice2 == 'd'){
						splitScore = dDraw(splitDeck, splitScore, splitIndex, input);
						splitIndex++;
						
						
					}
				}
				
			if(playerScore > 21 && splitScore > 21){
				
				System.out.println("Sorry both decks lose");
				
				going = false;
				play = false;
				
				
			}
			
			
			if((choice1 == 's' && choice2 == 's') || (playerScore > 21 && choice2 == 's') || (choice1 == 's' && splitScore > 21)){
				
				dealer = dealerResult(dealerDeck, dealerScore, dealerIndex, input);
				dealerScore = dealer.getDealerScore();
				dealerIndex = dealer.getDealerIndex();
				
				money = result(playerDeck, dealerDeck, playerScore, dealerScore, money, bet, bust, "Deck 1", blackjack);
				
				money = result(splitDeck, dealerDeck, splitScore, dealerScore, money, bet, bust, "Deck 2", blackjack2);
				
				going = false;
				
				play = false;
				
				
			}
			
			
			
			} //while go
		} // if f
		
		} // while play
		
		return money;
	}
	
	private static void print(Deck deck, int score, String who){
		System.out.println( who + " currently has: " + score);
		for(int i = 0; i <deck.deckSize(); i++){
		System.out.println(deck.printCard(i));
		}
		System.out.print("\n");
	}
	
	private static int dDraw(Deck thisDeck, int playerScore, int playerIndex, Scanner input){
		
		deck.dealCard(thisDeck);
		System.out.println("You were dealt \n");
		thisDeck.showCard(playerIndex);

		input.nextLine();
		if(thisDeck.aceCheck(playerIndex)){
			
			System.out.println("You were dealt an Ace, would you like it to be a 1 or 11?");
			int ace = input.nextInt();
			while(ace != 1 && ace != 11){
				System.out.println("Invalid number, choose 1 or 11");
				ace = input.nextInt();
			}
			if(ace == 1){
				playerScore = playerScore + 1;
			}
			else if (ace == 11){
				playerScore = playerScore + 11;
			
			}
			
		}
		else
		{
			playerScore = playerScore + thisDeck.cardValue(playerIndex);
		}
		
		
		return playerScore;
	}
	
	private static int result(Deck pDeck, Deck dDeck, int playerScore, int dealerScore, 
						int money, int bet, int bust, String s, boolean blackjack){
		
		
		
		print(dDeck, dealerScore, "Dealer");
		
		print(pDeck, playerScore, s);
		
		if(playerScore > 21){
			System.out.println("Sorry you lost $" + bet + "\n");
			
			
		}
		
		else if(dealerScore > 21){
			System.out.println("Congratulations you win $" + bet + "\n");
			money = money + bet*2;
			if(bust > 0){
				
				
			}
			
		}
		else if(playerScore == dealerScore){
			System.out.println("It was a tie, you get $" + bet + " back\n");
			money = money + bet;
			
		}
		
		else if(playerScore > dealerScore){
			
			
			if(blackjack == true){
				int bet2 = 0;
				bet2 = bet + bet/4;
				System.out.println("Congratulations you win $" + bet2 + "\n");
				money = money + bet + bet2;
				
			}
			else{
			System.out.println("Congratulations you win $" + bet + "\n");
			money = money + bet*2;
			
			}
		}
		else{
			System.out.println("Sorry you lost $" + bet + "\n");
			
			
		}
		
		return money;
	}
	
	private static Dealer dealerResult(Deck dDeck, int dealerScore, int dealerIndex, Scanner input){
		while(dealerScore < 17){  // dealer always stands at 17 and dealer can see player's score so no need to go over their score
			print(dDeck, dealerScore, "Dealer");
			
			
			
			deck.dealCard(dDeck);
			System.out.println("Dealer draws  \n");

			dDeck.showCard(dealerIndex);
			
			input.nextLine();
			
			if(dDeck.aceCheck(dealerIndex)){
				if(dealerScore >= 11){
					dealerScore = dealerScore + 1;
				}
				else {
					dealerScore = dealerScore +11;
				}
				
			}
			else{
			dealerScore = dealerScore + dDeck.cardValue(dealerIndex);
			}
			
			dealerIndex++;
		}
		
		return new Dealer(dDeck, dealerScore, dealerIndex);
	}

} // final


