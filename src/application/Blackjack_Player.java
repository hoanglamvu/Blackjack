package application;
import java.util.ArrayList;

public class Blackjack_Player {
protected int chips;
protected  ArrayList<Card> hand = new ArrayList<>();


public Blackjack_Player()
{
	chips = 200;
}

public Blackjack_Player(int chipamount)
{
	chips = chipamount;
}

public int getChips()
{
	return chips;
}

public void addChips(int a)
{
	chips+=a;
}

public Card getCard(int index)
{
	return hand.get(index);
}

public int getScore()
{
	int total = 0;
	int count=0;
	for (int i = 0; i < hand.size(); i++)
	{
		Card placeholder = hand.get(i);
		int value = placeholder.getValue();
		
		if(value > 10)
		{
			value = 10;
		}
		
		if(value == 1)
		{
			count++;
			value = 11;
		}
		
		total += value;
		
	}
	for(int i=0;i < count;i++)
		
	{
		if((total>21))
		{
			total = total - 10;
		}
	}
	return total;
}
public void addCard(Card c)
{
	hand.add(c);
}

public void printHand()
{
	System.out.print("player has ");
	for(int i = 0; i < hand.size(); i++)
	{
		Card current = hand.get(i);
		System.out.print(current.toString() + ", ");
	}
}

}