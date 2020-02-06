/**
 * An interface to define types of cards and their
 * values.
 *  
 * @author Cecil Wilson
 *
 */
interface cards
{
	/**
	 * The number of values of cards
	 */
	final int VALUE_COUNT = 13;
	
	/**
	 * The number of types of cards
	 */
	final int SUIT_COUNT = 4;
	
	/**
	 * The different values of standard playing cards
	 */
	final char[] STANDARD_VALUES = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	
	/**
	 * The different types of standard playing cards
	 */
	final String[] SUITS = {"C", "D", "H", "S"};
	
}

/**
 * The Card class handles the creation
 * of cards. It also allows the ability 
 * to use cards by finding their type and
 * value;
 * 
 * @author Cecil Wilson
 *
 */
public class Card implements cards {

	private char value;
	private String suit;
	
	Card()
	{
		
	}
	
	/**
	 * The constructor for a cards which
	 * also defines a value and suit.
	 * 
	 * 
	 * @param value | char - The rank of a card
	 * @param suit | String - the card type
	 */
	Card(char value, String suit)
	{
		this.value = value;
		this.suit = suit;
	}
	
	/**
	 * This method initiates all of the different standard
	 * playing cards as they are  defined in the cards interface
	 * 
	 * @param size | int - the number of cards to be created
	 * @return an array of cards
	 */
	Card[] createStandardPlayingCards(int size)
	{
		Card[] cards = new Card[size];
		int cardCount = 0;
		
		for(int i = 0; i < SUIT_COUNT; i++)
		{
			for(int j = 0; j < VALUE_COUNT; j++)
			{
				if(cardCount < size)
				{
					cards[cardCount] = new Card(STANDARD_VALUES[j], SUITS[i]);
					cardCount++;
				}
			}
		}
		
		return cards;
	}
	
	public void setValue(char val)
	{
		this.value = val;
	}
	
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	
	public char getValue()
	{
		return this.value;
	}
	
	/**
	 * This method returns the value
	 * of a given card represented
	 * as an int
	 * 
	 * @return an int - the value of the card
	 */
	public int getIntValue()
	{
		char value = this.value;
		
		switch(value)
		{
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;
			case 'T': return 10;
			case 'J': return 11;
			case 'Q': return 12;
			case 'K': return 13;
			case 'A': return 14;
		}
		
		return 0;
	}
	public String getSuit()
	{
		return this.suit;
	}
}
