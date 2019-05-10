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
		boolean stop = false;
		
		while (stop == false){
		
		startPrompt();
		
		prompt(currentMoney);
		
		deck.show(1);
		
		decision = input.next().charAt(0);
		
		if(decision == 'y'){
			
			prompt(currentMoney);
			
		}
		else if(decision == 'n'){
			
			
			
			stop = true;
			System.out.println("Thank you for playing, Good Bye.");
			
		}
		
		
		
		} // while loop
	} // main
	
	
	private static void startPrompt(){
		System.out.println("Welcome to a game of 21");
		// System.out.println("All Players start with $500");
		
		
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
