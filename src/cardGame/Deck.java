package cardGame;

import java.io.*;
import java.util.*;

public class Deck {
	
	private ArrayList<Cards> Card = new ArrayList<Cards>();
	
	
	
	public void deleteCard(int pos){
		
		Card.remove(pos);
		
	}
	
	public void showCard(int current){
		
		System.out.println(Card.get(current).getName());
		System.out.println("\n");
		
	}
	
	public int cardValue(int index){
		
		return Card.get(index).getValue();
		
	}
	
	public int deckSize(){
		return Card.size();
	}

	public void clearDeck(){
		
		Card.clear();
		
	}
	
	public boolean isEmpty(){
		
		return Card.isEmpty();		
	}
	
	
	public boolean aceCheck(int i){
		
		return Card.get(i).getCheckAce();
		
	}
	
	public void shuffleDeck(){
		
		Collections.shuffle(Card);
		
	}
	
	public void addCard(Cards deck){
		
		Card.add(deck);
		
	}
	
	public void dealCard(Deck deck2){
		
		deck2.addCard(Card.get(0));
		deleteCard(0);
		
	}
	
	public void setDeck(){
		
		clearDeck();
		
		Card.add(new Cards("ADiamond", 11, true));
		Card.add(new Cards("2Diamond", 2, false));
		Card.add(new Cards("3Diamond", 3, false));
		Card.add(new Cards("4Diamond", 4, false));
		Card.add(new Cards("5Diamond", 5, false));
		Card.add(new Cards("6Diamond", 6, false));
		Card.add(new Cards("7Diamond", 7, false));
		Card.add(new Cards("8Diamond", 8, false));
		Card.add(new Cards("9Diamond", 9, false));
		Card.add(new Cards("10Diamond", 10, false));
		Card.add(new Cards("JDiamond", 10, false));
		Card.add(new Cards("QDiamond", 10, false));
		Card.add(new Cards("KDiamond", 10, false));
		
		Card.add(new Cards("AClub", 11, true));
		Card.add(new Cards("2Club", 2, false));
		Card.add(new Cards("3Club", 3, false));
		Card.add(new Cards("4Club", 4, false));
		Card.add(new Cards("5Club", 5, false));
		Card.add(new Cards("6Club", 6, false));
		Card.add(new Cards("7Club", 7, false));
		Card.add(new Cards("8Club", 8, false));
		Card.add(new Cards("9Club", 9, false));
		Card.add(new Cards("10Club", 10, false));
		Card.add(new Cards("JClub", 10, false));
		Card.add(new Cards("QClub", 10, false));
		Card.add(new Cards("KClub", 10, false));
	
		Card.add(new Cards("AHeart", 11, true));
		Card.add(new Cards("2Heart", 2, false));
		Card.add(new Cards("3Heart", 3, false));
		Card.add(new Cards("4Heart", 4, false));
		Card.add(new Cards("5Heart", 5, false));
		Card.add(new Cards("6Heart", 6, false));
		Card.add(new Cards("7Heart", 7, false));
		Card.add(new Cards("8Heart", 8, false));
		Card.add(new Cards("9Heart", 9, false));
		Card.add(new Cards("10Heart", 10, false));
		Card.add(new Cards("JHeart", 10, false));
		Card.add(new Cards("QHeart", 10, false));
		Card.add(new Cards("KHeart", 10, false));
		
		Card.add(new Cards("ASpade", 11, true));
		Card.add(new Cards("2Spade", 2, false));
		Card.add(new Cards("3Spade", 3, false));
		Card.add(new Cards("4Spade", 4, false));
		Card.add(new Cards("5Spade", 5, false));
		Card.add(new Cards("6Spade", 6, false));
		Card.add(new Cards("7Spade", 7, false));
		Card.add(new Cards("8Spade", 8, false));
		Card.add(new Cards("9Spade", 9, false));
		Card.add(new Cards("10Spade", 10, false));
		Card.add(new Cards("JSpade", 10, false));
		Card.add(new Cards("QSpade", 10, false));
		Card.add(new Cards("KSpade", 10, false));
		
		shuffleDeck();
	
	}
}
