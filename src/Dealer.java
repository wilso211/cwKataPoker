/**
 * Dealer is the class that does the handling of all 
 * the cards. It can shuffle the deck and it also takes 
 * cards from the deck to deal to player hands.
 * 
 * 
 * @author Cecil WIlson
 *
 */
public class Dealer {

	private Deck deck;
	
	Dealer()
	{
		
	}
	
	/**
	 * Dealer constructor with declaration of a deck
	 * 
	 * @param deck
	 */
	Dealer(Deck deck)
	{
		this.deck = deck;
	}
	
	/**
	 * This method takes the size of player
	 * hands, number of players, and the players
	 * then deals out cards from the deck to 
	 * player hands.
	 * 
	 * 
	 * @param handSize		| int - The size of each player hand
	 * @param numPlayers	| int - The number of players in the game	
	 * @param players		| Player[] - Array of the players of the game
	 */
	public void createPlayerHand(int handSize, int numPlayers, Player[] players)
	{	
		
		Hand[] playerHands = new Hand[numPlayers];
		
		for(int i = 0; i < numPlayers; i++)
		{
			playerHands[i] = new Hand(new Card[handSize], handSize);
		}
		
		for(int i = 0; i < handSize; i++)
		{
			for(int j = 0; j < numPlayers; j++)
			{
				if(this.deck.getCount() > numPlayers)
				{
					playerHands[j].getHandCards()[i] = this.deck.getTopCard();
				}
			}
		}
		
		for(int i = 0; i < numPlayers; i++)
		{
			players[i].setHand(playerHands[i]);
		}
	}
	
	/**
	 * This method calls the shuffling of the
	 * deck via riffle method
	 * 
	 */
	public void shuffleCards()
	{
		this.deck.riffleShuffleDeck();
	}
	
	public void setDeck(Deck deck)
	{
		this.deck = deck;
	}
	
	public Deck getDeck()
	{
		return this.deck;
	}
	
}
