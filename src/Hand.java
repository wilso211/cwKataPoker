/**
 * The Hand class defines an array of cards of
 * a defined size. It also lets use set the type 
 * of hand and also get integer representation of
 * that type. 
 * 
 * @author Cecil Wilson
 *
 */
public class Hand {

	private Card[] hand;
	private int handSize;
	private String handType;
	
	Hand()
	{
		
	}
	
	/**
	 * Constructor for a hand which sets the
	 * array of cards and the size of the hand.
	 * 
	 * @param hand | Card[] - the array of cards to be set
	 * @param handSize | int - the number of cards in the hand
	 */
	Hand(Card[] hand, int handSize)
	{
		this.hand = hand;
		this.handSize = handSize;
	}
	
	public void setHandCards(Card[] hand)
	{
		this.hand = hand;
	}
	
	public void setHandType(String type)
	{
		this.handType = type;
	}
	
	public Card[] getHandCards()
	{
		return this.hand;
	}
	
	public void setHandSize(int handSize)
	{
		this.handSize = handSize;
	}
	
	public int getHandSize()
	{
		return this.handSize;
	}
	
	public String getHandType()
	{
		return this.handType;
	}
	
	/**
	 * This method returns the integer representation
	 * of the different types of hands
	 * 
	 * 
	 * @return int- the value of the hand
	 */
	public int getHandIntValue()
	{
		String type = this.handType;
		
		switch(type)
		{
			case "Straight Flush":	return 9;
			case "Four of a Kind":	return 8;
			case "Full House":		return 7;
			case "Flush":			return 6;
			case "Straight":		return 5;
			case "Three of a Kind":	return 4;
			case "Two Pair":		return 3;
			case "Pair":			return 2;
			case "High Card":		return 1;
		}
		
		return 0;
	}
}
