package cardGame;

import java.io.*;
import java.util.*;

public class Deck {
	
	private ArrayList<Cards> Card = new ArrayList<Cards>();
	
	
	public void deleteCard(){
		
		
	}
	
	public void show(int current){
		
		System.out.println(Card.get(current).getName());
		
	}

	
	public void setDeck(){
		
		
		Card.add(new Cards("ADiamond", 1, true));
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
		
		Card.add(new Cards("AClub", 1, true));
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
	
		Card.add(new Cards("AHeart", 1, true));
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
		
		Card.add(new Cards("ASpade", 1, true));
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
	
	}
}
