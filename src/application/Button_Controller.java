package application;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Button_Controller  extends Main{
@FXML
Label WinorLose = new Label();
@FXML
Label EnterBet = new Label();
@FXML
TextField TypeText = new TextField();
@FXML
TextField EnterName = new TextField();
@FXML
Label showBet = new Label();
@FXML
Label Chips = new Label();
@FXML
Button HitButton = new Button();
@FXML
Button StayButton = new Button();
@FXML
ImageView PlayCard1 = new ImageView();
@FXML
ImageView PlayCard2 = new ImageView();
@FXML
ImageView PlayCard3 = new ImageView();
@FXML
ImageView PlayCard4 = new ImageView();
@FXML
ImageView PlayCard5 = new ImageView();
@FXML
ImageView PlayCard6 = new ImageView();
@FXML
ImageView PlayCard7 = new ImageView();
@FXML
ImageView PlayCard8 = new ImageView();
@FXML
ImageView DealCard1 = new ImageView();
@FXML
ImageView DealCard2 = new ImageView();
@FXML
ImageView DealCard3 = new ImageView();
@FXML
ImageView DealCard4 = new ImageView();
@FXML
ImageView DealCard5 = new ImageView();
@FXML
ImageView DealCard6 = new ImageView();
@FXML
ImageView DealCard7 = new ImageView();
@FXML
ImageView DealCard8 = new ImageView();
@FXML
Button ResetButton = new Button();
@FXML
Label DisplayWin = new Label();

    HashMap<String, Image> images = new HashMap<String, Image>();
    Blackjack hello = getBlack();
    Card test = new Card(7,4);
    String cardTest = test.toString();
	static int count=2;
	static boolean bust;
	String bet="0";
	String name;
	
	
	public void newGame()
	{
		makeInvisible();
		count = 2;
		hello.reset();
		hello.diddly.shuffleDeck();
		hello.diddly.printDeck();
		TypeText.setVisible(true);
		EnterBet.setVisible(true);
		showBet.setVisible(false);
		ResetButton.setVisible(false);
		DisplayWin.setVisible(false);
	}
	
	public void createMap()
	{
		String[] iList = {"ace_of_clubs.jpg", "2_of_clubs.jpg", "3_of_clubs.jpg", "4_of_clubs.jpg", "5_of_clubs.jpg", "6_of_clubs.jpg", "7_of_clubs.jpg", "8_of_clubs.jpg", "9_of_clubs.jpg", "10_of_clubs.jpg", "jack_of_clubs.jpg", "queen_of_clubs.jpg", "king_of_clubs.jpg",
				          "ace_of_spades.jpg", "2_of_spades.jpg", "3_of_spades.jpg", "4_of_spades.jpg", "5_of_spades.jpg", "6_of_spades.jpg", "7_of_spades.jpg", "8_of_spades.jpg", "9_of_spades.jpg", "10_of_spades.jpg", "jack_of_spades.jpg", "queen_of_spades.jpg", "king_of_spades.jpg", 
				          "ace_of_hearts.jpg", "2_of_hearts.jpg", "3_of_hearts.jpg", "4_of_hearts.jpg", "5_of_hearts.jpg", "6_of_hearts.jpg", "7_of_hearts.jpg", "8_of_hearts.jpg", "9_of_hearts.jpg", "10_of_hearts.jpg", "jack_of_hearts.jpg", "queen_of_hearts.jpg", "king_of_hearts.jpg", 
				          "ace_of_diamonds.jpg", "2_of_diamonds.jpg", "3_of_diamonds.jpg", "4_of_diamonds.jpg", "5_of_diamonds.jpg", "6_of_diamonds.jpg", "7_of_diamonds.jpg", "8_of_diamonds.jpg", "9_of_diamonds.jpg", "10_of_diamonds.jpg", "jack_of_diamonds.jpg", "queen_of_diamonds.jpg", "king_of_diamonds.jpg"};
		for(int i = 0; i < 52; i++)
		{
			Image sup = new Image("application/deck/" + iList[i]);
			String x = hello.map.deck.get(i).toString();
			images.put(x ,sup);
		}
		
	}
	public void ClickStay()
	{
		DealCard1.setImage(images.get(hello.dealer.getCard(0).toString()));
		StayButton.setDisable(true);
		HitButton.setDisable(true);
		int count=2;
		while(hello.dealer.getScore()<17)
		{
			hello.deal(hello.dealer);
			count++;
			
		if(count==3)
		{
			DealCard3.setImage(images.get(hello.dealer.getCard(2).toString()));
			
		}
		if(count==4)
		{
			DealCard4.setImage(images.get(hello.dealer.getCard(3).toString()));
		}
		if(count==5)
		{
			DealCard5.setImage(images.get(hello.dealer.getCard(4).toString()));
		}
		if(count==6)
		{
			DealCard6.setImage(images.get(hello.dealer.getCard(5).toString()));
		}
		if(count==7)
		{
			DealCard7.setImage(images.get(hello.dealer.getCard(6).toString()));
		}
		if(count==8)
		{
			DealCard8.setImage(images.get(hello.dealer.getCard(7).toString()));
		}
		
		}
		
		hello.win(hello.player1, hello.dealer);
		Chips.setText("Your Chips: " + hello.player1.getChips());
		if(hello.didWin)
		{
			DisplayWin.setText("You Win!");
			ResetButton.setVisible(true);
			DisplayWin.setVisible(true);
		}
		else
		{
			DisplayWin.setText("You Lose");
			ResetButton.setVisible(true);
			DisplayWin.setVisible(true);
		}
	}

	public void ClickDeal()
	{
		makeInvisible();
		createMap();
		System.out.println("Deal");
		hello.deal(hello.player1);
		hello.deal(hello.player1);
		hello.deal(hello.dealer);
		hello.deal(hello.dealer);
		PlayCard1.setImage(images.get(hello.player1.getCard(0).toString()));
		PlayCard2.setImage(images.get(hello.player1.getCard(1).toString()));
		Image back = new Image("application/deck/back.jpg");
		DealCard1.setImage(back);
		DealCard2.setImage(images.get(hello.dealer.getCard(1).toString()));
	}
	
	public void makeInvisible()
	{
		PlayCard1.setImage(null);
		PlayCard2.setImage(null);
		PlayCard3.setImage(null);
		PlayCard4.setImage(null);
		PlayCard5.setImage(null);
		PlayCard6.setImage(null);
		PlayCard7.setImage(null);
		PlayCard8.setImage(null);
		
		DealCard1.setImage(null);
		DealCard2.setImage(null);
		DealCard3.setImage(null);
		DealCard4.setImage(null);
		DealCard5.setImage(null);
		DealCard6.setImage(null);
		DealCard7.setImage(null);
		DealCard8.setImage(null);
	}
	public void getBet()
	{
		try{
			bet = TypeText.getText();
			System.out.println(bet);
			Integer x = new Integer(bet);
			hello.p1bet = x;
			hello.player1.chips -= x;
			Chips.setText("Your Chips: " + hello.player1.getChips());
			TypeText.setVisible(false);
			showBet.setText("Your bet is: "+bet);
			}
			catch(NumberFormatException ex)
			{
				showBet.setText("Enter a number");
			}
		TypeText.setVisible(false);
		EnterBet.setVisible(false);
		HitButton.setDisable(false);
		StayButton.setDisable(false);
		//Chips.setText("Your Chips: " + hello.player1.getChips());
		
		ClickDeal();
	}
	
	
	public void ClickHit()
	{
		count++;
		hello.deal(hello.player1);
		if(hello.player1.getScore() == 21)
		{
			ClickStay();
		}
		if(count==3)
		{
			PlayCard3.setImage(images.get(hello.player1.getCard(2).toString()));
			if(hello.didBust(hello.player1))
			{
				StayButton.setDisable(true);
				HitButton.setDisable(true);
				DisplayWin.setText("You Lose");
			    ResetButton.setVisible(true);
				DisplayWin.setVisible(true);
				
				
				//Need to start Dealer subroutine
			}
		
			
		}
		else if(count==4)
		{
			PlayCard4.setImage(images.get(hello.player1.getCard(3).toString()));
			if(hello.didBust(hello.player1))
			{
				StayButton.setDisable(true);
				HitButton.setDisable(true);
				DisplayWin.setText("You Lose");
			    ResetButton.setVisible(true);
				DisplayWin.setVisible(true);
				//Need to start Dealer subroutine
			}
		}
		else if(count==5)
		{
			PlayCard5.setImage(images.get(hello.player1.getCard(4).toString()));
			if(hello.didBust(hello.player1))
			{
				StayButton.setDisable(true);
				HitButton.setDisable(true);
				DisplayWin.setText("You Lose");
			    ResetButton.setVisible(true);
				DisplayWin.setVisible(true);
				//Need to start Dealer subroutine
			}
		}
		else if(count==6)
		{
			PlayCard6.setImage(images.get(hello.player1.getCard(5).toString()));
			if(hello.didBust(hello.player1))
			{
				StayButton.setDisable(true);
				HitButton.setDisable(true);
				DisplayWin.setText("You Lose");
			    ResetButton.setVisible(true);
				DisplayWin.setVisible(true);
				//Need to start Dealer subroutine
			}
		}
		else if(count==7)
		{
			PlayCard7.setImage(images.get(hello.player1.getCard(6).toString()));
			if(hello.didBust(hello.player1))
			{
				StayButton.setDisable(true);
				HitButton.setDisable(true);
				DisplayWin.setText("You Lose");
			    ResetButton.setVisible(true);
				DisplayWin.setVisible(true);
				//Need to start Dealer subroutine
			}
		}
		else if(count==8)
		{
			PlayCard8.setImage(images.get(hello.player1.getCard(7).toString()));
			if(hello.didBust(hello.player1))
			{
				StayButton.setDisable(true);
				HitButton.setDisable(true);
				DisplayWin.setText("You Lose");
			    ResetButton.setVisible(true);
				DisplayWin.setVisible(true);
				//Need to start Dealer subroutine
			}
		}
		
	}
}
