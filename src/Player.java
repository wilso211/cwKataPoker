/**
 * The Player class defines the player of the game
 * and sets the hand of the player. It also
 * sets whether the player has won, lost or 
 * tied.
 * 
 * 
 * @author Cecil Wilson
 *
 */
public class Player {

	private boolean isWinner;
	private boolean isTie;
	private Hand hand;
	
	Player()
	{
		this.isWinner = false;
		this.isTie = false;
	}
	
	public void setWinner()
	{
		this.isWinner = true;
	}
	
	public void setTie()
	{
		this.isTie = true;
	}
	public void setLoser()
	{
		this.isWinner = false;
	}
	
	public void setHand(Hand hand)
	{
		this.hand = hand;
	}
	
	public boolean getWinner()
	{
		return this.isWinner;
	}
	
	public boolean getTie()
	{
		return this.isTie;
	}
	
	public Hand getHand()
	{
		return this.hand;
	}
}
