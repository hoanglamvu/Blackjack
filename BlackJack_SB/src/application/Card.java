package application;

public class Card {
	private int value;
    private String name;
	private int suit;
	//1-Clubs
	//2-Spades
	//3-Hearts
	//4-Diamonds

	public Card (int v, int s) {
		
		value = v;
		suit = s; 
		setName();
		
	}
	
	public void setName()
	{
		if (value < 11 && value != 1)
		{
			name = value + "";
		}
		else if (value == 11)
		{
			name = "Jack";
		}
		else if (value == 12)
		{
			name = "Queen";
		}
		else if (value == 13)
		{
			name = "King";
		}
		else if (value == 1)
		{
			name = "Ace";
		}
	}

	public int getValue(){
	return value;
	}

	public int getSuit(){
	return suit;
	}
	public String getName(){
		return name;
	}
	public String suitName() {
	if(suit == 1)
	return "Clubs";
	else if (suit == 2)
	return "Spades";
	else if (suit == 3)
	return "Hearts";
	else if (suit == 4)
	return "Diamonds";
	else{return "invalid suit"; }
	}
	

	public String toString(){
	String s = name  + " of " + suitName();
	return s; }
}


