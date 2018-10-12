package application;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	ArrayList<Card> deck= new ArrayList<Card>();
	String name="”test";
	
    public Deck()
    {
    	createDeck();
    	shuffleDeck();
    }
    
    
	public void createDeck()
	{
		for(int i=1;i<=4;i++)
		{
			for(int k=1;k<=13;k++)
			{
				Card card=new Card(k,i);
				deck.add(card);
			}	
		}
		
		
	}
	//DEBUG
	public void printDeck()
	{
		for(int i=0;i<deck.size();i++)
		{
			System.out.println(deck.get(i).toString());
		}
	}
	
	public void shuffleDeck()
	{
		for(int i=0;i<100000;i++)
		{
			Random random=new Random();
			int move=random.nextInt(52);
			Card temp= deck.get(move);
			deck.remove(move);
			deck.add(temp);
			
		}
	}
}





