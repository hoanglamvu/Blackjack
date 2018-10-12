package application;
import java.util.Scanner;

public class Blackjack extends Deck{
	Blackjack_Player player1= new Blackjack_Player();
	Blackjack_Dealer dealer = new Blackjack_Dealer();
	public Deck map = new Deck(true);
	public Deck diddly= new Deck();
	public int players=0;
	public boolean didWin;
	int p1bet=0;
	Scanner kbreader=new Scanner(System.in);
	
	public void deal(Blackjack_Player e){
	e.addCard(diddly.deck.get(0));
	Card temp = diddly.deck.get(0);
	diddly.deck.remove(0);
	diddly.deck.add(temp);
	}
	
	public void bet()
	{
		System.out.print("How much would you like to bet?:");
		p1bet=kbreader.nextInt();
		System.out.println("Your Bet is: "+p1bet);
	}
	public Blackjack_Player getPlayer()
	{
		return player1;
	}
	
	public String getPlayerCard(int i)
	{
		return player1.getCard(i).toString();
	}
	
	public Blackjack_Dealer getDealer()
	{
		return dealer;
	}
	
	public boolean didBust(Blackjack_Player e)
	{
		boolean bust=false;
		if(e.getScore()>21)
		{
			bust=true;
			System.out.println("You Busted!");
		}
		return bust;
	}
	public void playgame()
	{
		bet();
		deal(player1);
		deal(player1);
		player1.printHand();
		play();	
		dealer.scoreDisplay();
		win(player1,dealer);
	}
	public void play()
	{
		boolean run=true;
		
		while(run)
		{
			System.out.print("1 for hit, 2 for stay ");
			if(kbreader.nextInt()==1)
			{
				deal(player1);
				if(didBust(player1))
				{
					run=false;
				}
			}
			if(kbreader.nextInt()==2)
			{
				run=false;
			}
			player1.printHand();
		}
	}
	public void reset()
	{
		player1.hand.clear();
		dealer.hand.clear();
	}
	public Deck getDeck()
	{
		return diddly;
	}
	public void win(Blackjack_Player a,Blackjack_Dealer b)
	{
		if(a.getScore()>b.getScore()|| b.getScore() > 21){
			System.out.println("you won "+p1bet);
			player1.addChips(p1bet * 2);
			didWin = true;
		}
		else
		{
			int betAfter = p1bet-(p1bet*2);
			System.out.println("you lost "+betAfter);
			//player1.addChips(p1bet);
			didWin = false;
		}
	}
	
}	
