package cardGame;

import java.util.Scanner;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// Variables
		
		@SuppressWarnings("resource")			// recommended by IDE
		Scanner input = new Scanner(System.in);
		
		Deck deck = new Deck();
		
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
			
			prompt(currentMoney);
			
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
					
					System.out.println("There are this many cards :" + deck.deckSize());
					
				}
				else if(dec == 'c'){
					
					deck.clearDeck();
					System.out.println("Deck has been cleared");
					
				}
				else if(dec == 's'){
					
					deck.setDeck();
					System.out.println("You set the deck");
					
				}
				else if(dec == 'd'){
					
					deck.showCard(0);
					
				}
				else if(dec == 'f'){
					
					deck.shuffleDeck();
					
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
		System.out.println("Type y for Yes or n for No");
		
		
	}
	
	private static void admin(){
		System.out.println("This is Admin Controls");
		System.out.println("What would you like to do?");
		System.out.println("Type n for current deck size");
		System.out.println("Type d to show top card");
		System.out.println("Type c to clear the deck");
		System.out.println("Type s to set the deck");
		System.out.println("Type f to shuffle the deck");
		System.out.println("Type b to go back");
		
	}
	
	private static void prompt(int money){
		System.out.println("You Currently have $" + money);
		System.out.println("Would you like to continue this game?");
		System.out.println("Enter y for yes and n for no");
		System.out.println("\n");
		
	}
	
	private static int game(int money){
		
		
		
		return money;
	}

} // final
