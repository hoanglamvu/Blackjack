package application;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Random;

//import javafx.scene.image.Image;

public class Deck {
	ArrayList<Card> deck= new ArrayList<Card>();
	
	String name="�test";
	
    public Deck()
    {
    	createDeck();
    	shuffleDeck();
    }
    
    public Deck(boolean y)
    {
    	if(y)
    	{
    		createDeck();
    	}
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
		java.util.Collections.shuffle(deck);

	}
	public void shuffler()
 {
	int counter = 100;
	while(counter > 0)
	{
	  for (int i = 0; i < 52; i++)
	  {
	      double random = Math.random() * 52;
	      Card temp = deck.get(i);
	      deck.remove(temp);
	      deck.add((int) random, temp);
	  }
	  counter--;
	}
 }
}





