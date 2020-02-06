/**
 * The Deck class allows the creation of a deck 
 * of cards, the shiffling of a deck of cards, as 
 * well as returning a card off of the top of the
 * deck of cards. 
 * 
 * @author Cecil Wilson
 * 
 */

import java.util.Random;

public class Deck {
	
	/**
	 * The number of cards in a deck
	 * 
	 */
	private final int DECK_SIZE = 52;
	
	private int shuffleAmount;
	private int size;
	private int cardCount;
	private Card[] cards;
	
	private Card card = new Card();
	
	Deck()
	{
		this.size = DECK_SIZE;
	}
	
	/**
	 * Constructor for a deck with definition for
	 * card and the count of the cards
	 * 
	 * @param card | Card - the card to be added to the deck
	 * @param cardCount | int - the number of cards in the deck
	 */
	Deck(Card card, int cardCount)
	{
		this.size = DECK_SIZE;
		this.cards[cardCount] = card;
		this.cardCount = cardCount;
	}
	
	/**
	 * This method creates and then returns
	 * a full deck of cards
	 * 
	 * 
	 * @return A deck of cards
	 */
	public Deck createDeck()
	{
		Deck myDeck = new Deck();
		Card[] initialCards = getInitialCards(DECK_SIZE);
		myDeck.setDeckCards(initialCards);
		myDeck.cardCount = myDeck.cards.length;
		
		return myDeck;
	}
	
	
	Card[] getInitialCards(int size)
	{
		Card[] initialCards = new Card[size];
		initialCards = card.createStandardPlayingCards(size);
		return initialCards;
	}

	/**
	 * This method shuffles he cards within
	 * a deck using the riffle method. The riffle
	 * method splits a deck into two equal pieces
	 * then combines the piles into one alternates
	 * between the piles one by one. It will
	 * shuffle the deck between 0 and 50 times. 
	 * The shuffle implementation is NOT a
	 * random shuffle and it is possible with
	 * enough shuffles to return to the original
	 * configuration of cards. 
	 * 
	 */
	void riffleShuffleDeck()
	{	
		//Set amount of times to shuffle
		Random rand = new Random();
		shuffleAmount = rand.nextInt(50);
		
		Card[] tempCards = new Card[DECK_SIZE];
		
		//Shuffle the declared amount of times
		for(int i = 0; i < shuffleAmount; i++)
		{
			// split deck in two
			int leftIndex = (DECK_SIZE / 2) - 1;	// 25 - 0 Start from middle of deck and work to top
			int rightIndex = DECK_SIZE - 1; 		// 51 - 26 Start from bottom of deck and work to middle
			
			int index = DECK_SIZE - 1;
			while(index > 0)
			{
				// Alternate cards between left and right
				tempCards[index] = this.cards[leftIndex];
				tempCards[index - 1] = this.cards[rightIndex];
				
				leftIndex--;
				rightIndex--;
				index = index - 2;
			}
			
			// Set the cards in the deck to now be the shuffled cards
			for(int j = 0; j < DECK_SIZE; j++)
			{
				this.cards[j] = tempCards[j];
			}
		}
		
	}
	
	void setDeckCards(Card[] cards)
	{
		this.cards = cards;
	}
	
	Card[] getDeckCards()
	{
		return this.cards;
	}
	
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getCount()
	{
		return this.cardCount;
	}
	
	
	/**
	 * This method returns the top card
	 * of a deck without removing the card
	 * from the deck. It also decrements the
	 * count of cards in the deck so that the
	 * next returned card would be the top card
	 * IF each card was actually removed from
	 * the deck.
	 * 
	 * 
	 * @return Card - the card that is currently defined to be on top of the deck 
	 */
	Card getTopCard()
	{
		if(this.cardCount != 0)
		{
			Card topCard = this.cards[this.size - this.cardCount];
			this.cardCount--;
			
			return topCard;
		}
		
		
		return null;
	}
}
