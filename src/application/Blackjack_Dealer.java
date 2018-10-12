package application;

public class Blackjack_Dealer extends Blackjack_Player{

	public void scoreDisplay()
	{
		Card display = this.hand.get(1);
		int val = display.getValue();
		if(val > 10)
		{
			val = 10;
		}
		else if (val == 1)
		{
			val = 11;
		}
		System.out.println("Dealer has a shown score of " + val);
	}

}
