package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Button_Controller  extends Main{
@FXML
Label PlayerCard1 = new Label();
@FXML
Label PlayerCard2 = new Label();
@FXML
Label PlayerCard3 = new Label();
@FXML
Label PlayerCard4 = new Label();
@FXML
Label PlayerCard5 = new Label();
@FXML
Label PlayerCard6 = new Label();
@FXML
Label DealerCard1 = new Label();
@FXML
Label DealerCard2 = new Label();
@FXML
Label DealerCard3 = new Label();
@FXML
Label DealerCard4 = new Label();
@FXML
Label DealerCard5 = new Label();
@FXML
Label DealerCard6 = new Label();
@FXML
Label WinorLose = new Label();
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
Button DealButton = new Button();
@FXML
Button StayButton = new Button();
@FXML
ImageView Viewer = new ImageView();


	Image image = new Image("Cards/2_of_clubs.jpg");
	static int count=2;
	static boolean bust;
	Deck gameDeck = new Deck();
	String bet="0";
	Blackjack hello = getBlack();
	String name;
	public void ClickStay()
	{
		Viewer.setImage(image);
		StayButton.setVisible(false);
		HitButton.setVisible(false);
		int count=2;
		while(hello.dealer.getScore()<17)
		{
			hello.deal(hello.dealer);
			count++;
			
		if(count==3)
		{
			DealerCard3.setText(hello.dealer.getCard(2).toString());
			
		}
		if(count==4)
		{
			DealerCard4.setText(hello.dealer.getCard(3).toString());
		}
		if(count==5)
		{
			DealerCard5.setText(hello.dealer.getCard(4).toString());
		}
		if(count==6)
		{
			DealerCard6.setText(hello.dealer.getCard(5).toString());
		}
		
		}
		
		hello.win(hello.player1, hello.dealer);
		
		
	}

	public void ClickDeal()
	{
		DealButton.setVisible(false);
		System.out.println("Deal");
		hello.deal(hello.player1);
		hello.deal(hello.player1);
		hello.deal(hello.dealer);
		hello.deal(hello.dealer);
		PlayerCard1.setText(hello.getPlayerCard(0));
		PlayerCard2.setText(hello.getPlayerCard(1));
		DealerCard1.setText(hello.dealer.getCard(0).toString());
		DealerCard2.setText(hello.dealer.getCard(1).toString());
	}
	public void getBet()
	{
		try{
			bet = TypeText.getText();
			System.out.println(bet);
			Integer x = new Integer(bet);
			hello.p1bet = x;
			hello.player1.chips -= x;
			Chips.setText(name +"'s chips: " + hello.player1.getChips());
			TypeText.setVisible(false);
			showBet.setText("Your bet is: "+bet);
			}
			catch(NumberFormatException ex)
			{
				showBet.setText("Enter a number ass");
			}
			
	}
	
	public void showChips()
	{
		name = EnterName.getText();
		Chips.setText(name+"'s chips: " + hello.player1.getChips());
		EnterName.setVisible(false);
		TypeText.setVisible(true);
		ClickDeal();
	}
	
	public void ClickHit()
	{
		count++;
		hello.deal(hello.player1);
		/*if(hello.player1.getScore() == 21)
		{
			ClickStay();
		}*/
		if(count==3)
		{
			PlayerCard3.setText(hello.getPlayerCard(2));
			if(hello.didBust(hello.player1))
			{
				HitButton.setVisible(false);
				//Need to start Dealer subroutine
			}
		
			
		}
		if(count==4)
		{
			PlayerCard4.setText(hello.getPlayerCard(3));
			if(hello.didBust(hello.player1))
			{
				HitButton.setVisible(false);
				//Need to start Dealer subroutine
			}
		}
		if(count==5)
		{
			PlayerCard5.setText(hello.getPlayerCard(4));
			if(hello.didBust(hello.player1))
			{
				HitButton.setVisible(false);
				//Need to start Dealer subroutine
			}
		}
		if(count==6)
		{
			PlayerCard6.setText(hello.getPlayerCard(5));
			if(hello.didBust(hello.player1))
			{
				HitButton.setVisible(false);
				//Need to start Dealer subroutine
			}
		}
		
		
	}
}
