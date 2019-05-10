package cardGame;

public class Cards {
	
	private int value;
	
	private String name;
	
	private boolean checkAce;
	
	
	public int getValue() { return this.value; } 
	
	public String getName(){ return this.name; }
	
	public boolean getCheckAce() { return this.checkAce; }
	
	
	public void setValue(int value){ this.value = value; }
	
	public void setName(String name){ this.name = name; }
		
	public void setCheckAce(boolean checkAce) { this.checkAce = checkAce; }
	
	public Cards(String name, int value, boolean checkAce){
		
	
		setName(name);
		setValue(value);
		setCheckAce(checkAce);
		
	}

}
