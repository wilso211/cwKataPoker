/**
 * This class prints information about the game to the
 * console
 * 
 * 
 * @author Cecil Wilson
 *
 */
public class Output {

	Output()
	{
		
	}
	
	/**
	 * This method takes a deck and prints the cards contained in it to
	 * the console.
	 * 
	 * @param deck
	 */
	public void printDeck(Deck deck)
	{
		for(int i = 0; i < deck.getSize(); i++)
		{
			System.out.println(deck.getDeckCards()[i].getValue() + deck.getDeckCards()[i].getSuit());
		}
	}
	
	/**
	 * This method takes a hand and prints the cards
	 * contained in it to the console
	 * 
	 * @param hand
	 */
	public void printHand(Card[] hand)
	{
		for(int i = 0; i < hand.length; i++)
		{
			System.out.print(hand[i].getValue() + hand[i].getSuit() + " ");
		}
	}
	
	/**
	 * This method takes and hand and prints 
	 * the hand's type to the console
	 * 
	 * @param hand
	 */
	public void printHandType(Hand hand)
	{
		System.out.println(hand.getHandType());
	}
	
	/**
	 * This method takes a player and a hand and prints that the
	 * player has won with their hand type to the console
	 * 
	 * @param player
	 * @param hand
	 */
	public void printWinner(int player, Hand hand)
	{
		System.out.println("Player " + (player + 1) + " wins with a " + hand.getHandType());
		System.out.println("==============================");
	}
	
	/**
	 * This method prints that the game has resulted in 
	 * a tie to the console
	 * 
	 */
	public void printTie()
	{
		System.out.println("The game is a tie.");
		System.out.println("==============================");
	}
}
