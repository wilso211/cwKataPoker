/** 
 * The Ranks interface defines the types of 
 * methods that can be used to define hands 
 * of cards.
 * 
 * @author Cecil Wilson
 *
 */
interface Ranks 
{
	/**
	 * A straight flush is a hand with a sequence the value of 5 cards
	 * as well as 5 cards of the same type. 
	 * 
	 * It is the best hand.
	 * 
	 * @return true or false
	 */
	boolean isStraightFlush();
	
	/**
	 * FOAK is four of the same value of cards in a hand. 
	 * 
	 * It is the second best hand.
	 * 
	 * @return true or false
	 */
	boolean isFOAK();
	
	/**
	 * The full house is a hand with a TOAK and a Pair. 
	 * 
	 * It is the third best hand.
	 * 
	 * @return true or false
	 */
	boolean isFullHouse();
	
	/**
	 * A flush is 5 of the same card type. 
	 * 
	 * It is the fourth best hand.
	 * 
	 * @return true or false
	 */
	boolean isFlush();
	
	/**
	 * A straight is an ordered sequence of 5 card values [Ex. 2, 3, 4, 5 ,6].
	 * 
	 * It is the fifth best hand.
	 * 
	 * @return true or false
	 */
	boolean isStraight();
	
	/**
	 * TOAK is three of the same kind of card values
	 * 
	 * It is the sixth best hand
	 * 
	 * @return the index i of the TOAK or -1 if no TOAK is found
	 */
	int isTOAK();
	
	/**
	 * Two pair is when there are two different pairs in a hand, but no TOAK
	 * 
	 * It is the seventh best hand
	 * 
	 * @return true or false
	 */
	boolean isTwoPair();
	
	/**
	 * A pair is when a hand contains two cards of the same value, but no more.
	 * 
	 * The eighth best hand.
	 * 
	 * @return the index i of the pair or -1 if no pair is found.
	 */
	int isPair();
	
	/**
	 * A high card results when there are no other types of hands that are present
	 * and the hand has to be ranked by the highest value card in the hand
	 * 
	 * The worst type of hand
	 * 
	 * @return true or false
	 */
	boolean highCard();
}

/**
 * The Compare class defines what type of hand a player has. 
 * It then compares the types of hands of the players has and 
 * determines which is the best hand.  The types are (in increasing order):
 *<p>•	HIGH CARD: Hands which do not fit any higher category are 
 *	ranked by the value of their highest card. If the highest cards 
 *	have the same value, the hands are ranked by the next highest, and so on.
 *
 *<p>•	PAIR: 2 of the 5 cards in the hand have the same value. Hands 
 *	which both contain a pair are ranked by the value of the cards forming 
 *	the pair. If these values are the same, the hands are ranked by the values
 *	 of the cards not forming the pair, in decreasing order.
 *
 *<p>•	TWO PAIR: The hand contains 2 different pairs. Hands which both contain 
 *	2 pairs are ranked by the value of their highest pair. Hands with the same 
 *	highest pair are ranked by the value of their other pair. If these values
 *	are the same the hands are ranked by the value of the remaining card.
 *
 *<p>•	THREE OF A KIND: Three of the cards in the hand have the same value.
 *	Hands which both contain three of a kind are ranked by the value of the 3 cards.
 *
 *<p>•	STRAIGHT: Hand contains 5 cards with consecutive values. Hands which
 *	both contain a straight are ranked by their highest card.
 *
 *<p>•	FLUSH: Hand contains 5 cards of the same suit. Hands which are both flushes
 *	are ranked using the rules for High Card.
 *
 *<p>•	FULL HOUSE: 3 cards of the same value, with the remaining 2 cards forming
 *	a pair. Ranked by the value of the 3 cards. If the 3 are the same, it is then 
 *	ranked by the value of the pair.
 * 
 *<p>•	FOUR OF A KIND: 4 cards with the same value. Ranked by the value of the 4 cards.
 *	If the value of the 4 are equal, the fifth card will determine rank.
 *
 *<p>•	STRAIGHT FLUSH: 5 cards of the same suit with consecutive values. 
 *	Ranked by the highest card in the hand.
 * 
 * @author Cecil wilson
 *
 */
public class Compare {

	private Game game;
	
	// Array of indices of card ranks.
	private Integer[] indexTOAK;
	private Integer[] indexFHTOAK;
	private Integer[] indexFHPair;
	private Integer[] indexPair;
	private Integer[] indexFOAK;
	private Integer[] indexHigherPair;
	private Integer[] indexLowerPair;
	
	Compare()
	{
		
	}
	
	/**
	 * The constructor of a Compare that also sets
	 * number of players to be compared.
	 * 
	 * @param numPlayers
	 */
	Compare(int numPlayers)
	{
		indexTOAK = new Integer[numPlayers];
		indexFHTOAK = new Integer[numPlayers];
		indexFHPair = new Integer[numPlayers];
		indexPair = new Integer[numPlayers];
		indexFOAK = new Integer[numPlayers];
		indexHigherPair = new Integer[numPlayers];
		indexLowerPair = new Integer[numPlayers];
	}
	
	/**
	 * This class calls for the type of hand to be declared, then starts
	 * the process of determining which hand is best.
	 * 
	 */
	public void compareHands()
	{
		this.declareHandTypes();
		
		Player[] players = this.game.getPlayers();
		
		int highest = 0;
		int compareValue = 0;
		
		for(int i = 0; i < this.game.getPlayers().length - 1; i++)
		{
			Hand firstHand = players[i].getHand();
			Hand secondHand = players[i + 1].getHand();
			
			if(this.compareTwoHands(firstHand, secondHand) == 1)
			{
				highest = i + 1;
			}
			else if(this.compareTwoHands(firstHand, secondHand) == -1)
			{
				compareValue = firstHand.getHandIntValue();
				
				switch(compareValue)
				{
					case 9: 	// Straight Flush
						if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 1)
						{
							highest = i + 1;
						}
						else if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 0)
						{
							highest = i;
						}
						else
						{
							highest = -1;
						}
						break;
					case 8:		// Four of a Kind
						if(firstHand.getHandCards()[this.getIndexFOAK(i)].getIntValue() 
								< secondHand.getHandCards()[this.getIndexFOAK(i + 1)].getIntValue())
						{
							highest = i + 1;
						}
						else if(firstHand.getHandCards()[this.getIndexFOAK(i)].getIntValue() 
								> secondHand.getHandCards()[this.getIndexFOAK(i + 1)].getIntValue())
						{
							highest = i;
						}
						else if(firstHand.getHandCards()[this.getIndexFOAK(i)].getIntValue() 
								== secondHand.getHandCards()[this.getIndexFOAK(i + 1)].getIntValue())
						{
							int checkIndex1 = 0;
							int checkIndex2 = 0;
							if(this.getIndexFOAK(i) == 0)
							{
								checkIndex1 = firstHand.getHandSize() - 1;
							}
							if(this.getIndexFOAK(i + 1) == 0)
							{
								checkIndex2 = secondHand.getHandSize() - 1;
							}
							
							if(firstHand.getHandCards()[checkIndex1].getIntValue() 
									< secondHand.getHandCards()[checkIndex2].getIntValue())
							{
								highest = i + 1;
							}
							else if(firstHand.getHandCards()[checkIndex1].getIntValue() 
									> secondHand.getHandCards()[checkIndex2].getIntValue())
							{
								highest = i;
							}
							else
							{
								highest = -1;
							}
							
						}
						else
						{
							highest = -1;
						}
						break;
					case 7:		// Full House
						if(firstHand.getHandCards()[this.getIndexFHTOAK(i)].getIntValue() 
								< secondHand.getHandCards()[this.getIndexFHTOAK(i + 1)].getIntValue())
						{
							highest = i + 1;
						}
						else if(firstHand.getHandCards()[this.getIndexFHTOAK(i)].getIntValue() 
								> secondHand.getHandCards()[this.getIndexFHTOAK(i + 1)].getIntValue())
						{
							highest = i;
						}
						else if(firstHand.getHandCards()[this.getIndexFHTOAK(i)].getIntValue() 
								== secondHand.getHandCards()[this.getIndexFHTOAK(i + 1)].getIntValue())
						{
							if(firstHand.getHandCards()[this.getIndexFHPair(i)].getIntValue() 
									< secondHand.getHandCards()[this.getIndexFHPair(i + 1)].getIntValue())
							{
								highest = i + 1;
							}
							else if(firstHand.getHandCards()[this.getIndexFHPair(i)].getIntValue() 
									> secondHand.getHandCards()[this.getIndexFHPair(i + 1)].getIntValue())
							{
								highest = i;
							}
							else
							{
								highest = -1;
							}
						}
						break;
					case 6:		// Flush
						if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 1)
						{
							highest = i + 1;
						}
						else if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 0)
						{
							highest = i;
						}
						else
						{
							highest = -1;
						}
						break;
					case 5:		// Straight
						if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 1)
						{
							highest = i + 1;
						}
						else if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 0)
						{
							highest = i;
						}
						else
						{
							highest = -1;
						}
						break;
					case 4:		// Three of a Kind
						if(firstHand.getHandCards()[this.getIndexTOAK(i)].getIntValue() 
								< secondHand.getHandCards()[this.getIndexTOAK(i + 1)].getIntValue())
						{
							highest = i + 1;
						}
						else if(firstHand.getHandCards()[this.getIndexTOAK(i)].getIntValue() 
								> secondHand.getHandCards()[this.getIndexTOAK(i + 1)].getIntValue())
						{
							highest = i;
						}
						else if(firstHand.getHandCards()[this.getIndexTOAK(i)].getIntValue() 
								== secondHand.getHandCards()[this.getIndexTOAK(i + 1)].getIntValue())
						{
							int checkIndex1 = 0;
							int checkIndex2 = 0;
							boolean check = false;
							
							for(int j = 0; j < firstHand.getHandSize() - 1; j++)
							{
								if(checkIndex1 == this.getIndexTOAK(i) || checkIndex1 == (this.getIndexTOAK(i) + 1) || checkIndex1 
										== (this.getIndexTOAK(i) + 2) && (checkIndex1 + 1) < firstHand.getHandSize())
								{
									check = false;
									checkIndex1++;
								}
								else
								{
									check = true;
								}
								if(checkIndex2 == this.getIndexTOAK(i + 1) || checkIndex2 == (this.getIndexTOAK(i + 1) + 1) || checkIndex2 
										== (this.getIndexTOAK(i + 1) + 2) && (checkIndex2 + 1) < secondHand.getHandSize())
								{
									check = false;
									checkIndex2++;
								}
								else
								{
									check = true;
								}
								
								if(check)
								{
									if(this.compareTwoCards(firstHand.getHandCards(), secondHand.getHandCards(), checkIndex1, checkIndex2) == 1)
									{
										highest = i + 1;
									}
									else if(this.compareTwoCards(firstHand.getHandCards(), secondHand.getHandCards(), checkIndex1, checkIndex2) == 0)
									{
										highest = i;
									}
									else
									{
										highest = -1;
									}
								}
							}
						}
						break;
					case 3:		// Two Pair
						if(firstHand.getHandCards()[this.getIndexHigherPair(i)].getIntValue() 
								< secondHand.getHandCards()[this.getIndexHigherPair(i + 1)].getIntValue())
						{
							highest = i + 1;
						}
						else if(firstHand.getHandCards()[this.getIndexHigherPair(i)].getIntValue() 
								> secondHand.getHandCards()[this.getIndexHigherPair(i + 1)].getIntValue())
						{
							highest = i;
						}
						else
						{
							if(firstHand.getHandCards()[this.getIndexLowerPair(i)].getIntValue() 
									< secondHand.getHandCards()[this.getIndexLowerPair(i + 1)].getIntValue())
							{
								highest = i + 1;
							}
							else if(firstHand.getHandCards()[this.getIndexLowerPair(i)].getIntValue() 
									> secondHand.getHandCards()[this.getIndexLowerPair(i + 1)].getIntValue())
							{
								highest = i;
							}
							else
							{
								int checkIndex1 = 0;
								int checkIndex2 = 0;
								boolean check = false;
								
								for(int j = 0; j < firstHand.getHandSize() - 1; j++)
								{
									if(checkIndex1 == this.getIndexHigherPair(i) || checkIndex1 == (this.getIndexHigherPair(i) + 1) 
											&& (checkIndex1 + 1) < firstHand.getHandSize())
									{
										check = false;
										checkIndex1++;
									}
									else
									{
										check = true;
									}
									
									if(checkIndex1 == this.getIndexLowerPair(i) || checkIndex1 == (this.getIndexLowerPair(i) + 1) 
											&& (checkIndex1 + 1) < firstHand.getHandSize())
									{
										check = false;
										checkIndex1++;
									}
									else
									{
										check = true;
									}
									
									if(checkIndex2 == this.getIndexHigherPair(i) || checkIndex2 == (this.getIndexHigherPair(i) + 1) 
											&& (checkIndex2 + 1) < secondHand.getHandSize())
									{
										check = false;
										checkIndex1++;
									}
									else
									{
										check = true;
									}
									
									if(checkIndex2 == this.getIndexLowerPair(i) || checkIndex2 == (this.getIndexLowerPair(i) + 1) 
											&& (checkIndex2 + 1) < secondHand.getHandSize())
									{
										check = false;
										checkIndex1++;
									}
									else
									{
										check = true;
									}
									
									if(check)
									{
										if(this.compareTwoCards(firstHand.getHandCards(), secondHand.getHandCards(), checkIndex1, checkIndex2) == 1)
										{
											highest = i + 1;
										}
										else if(this.compareTwoCards(firstHand.getHandCards(), secondHand.getHandCards(), checkIndex1, checkIndex2) == 0)
										{
											highest = i;
										}
										else
										{
											highest = -1;
										}
									}
								}
							}
						}
						break;
					case 2:		// Pair
						int checkIndex1 = 0;
						int checkIndex2 = 0;
						boolean check = false;
						
						for(int j = 0; j < firstHand.getHandSize() - 1; j++)
						{
							if(checkIndex1 == this.getIndexPair(i) || checkIndex1 == (this.getIndexPair(i) + 1) 
									&& (checkIndex1 + 1) < firstHand.getHandSize())
							{
								check = false;
								checkIndex1++;
							}
							else
							{
								check = true;
							}
							
							if(checkIndex2 == this.getIndexPair(i) || checkIndex2 == (this.getIndexPair(i) + 1) 
									&& (checkIndex2 + 1) < secondHand.getHandSize())
							{
								check = false;
								checkIndex1++;
							}
							else
							{
								check = true;
							}
							
							if(check)
							{
								if(this.compareTwoCards(firstHand.getHandCards(), secondHand.getHandCards(), checkIndex1, checkIndex2) == 1)
								{
									highest = i + 1;
								}
								else if(this.compareTwoCards(firstHand.getHandCards(), secondHand.getHandCards(), checkIndex1, checkIndex2) == 0)
								{
									highest = i;
								}
								else
								{
									highest = -1;
								}
							}
						}
					case 1:		// High Card
						if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 1)
						{
							highest = i + 1;
						}
						else if(this.findWhichHasHighest(firstHand.getHandCards(), secondHand.getHandCards()) == 0)
						{
							highest = i;
						}
						else
						{
							highest = -1;
						}
				}
			}
		}
		
		if(highest == -1)
		{
			for(int i = 0; i < players.length; i++)
			{
				players[i].setTie();
			}
		}
		else
		{
			players[highest].setWinner();
		}
	}
	
	/**
	 * This method determines what the type of hand is
	 * then sets the type to the hand
	 * 
	 */
	public void declareHandTypes()
	{
		for(int i = 0; i < this.game.getPlayers().length; i++)
		{
			if(isStraightFlush(i))
			{
				this.game.getPlayers()[i].getHand().setHandType("Straight Flush");
			}
			else if(isFOAK(i))
			{
				this.game.getPlayers()[i].getHand().setHandType("Four of a Kind");
			}
			else if(isFullHouse(i))
			{
				this.game.getPlayers()[i].getHand().setHandType("Full House");
			}
			else if(isFlush(i))
			{
				this.game.getPlayers()[i].getHand().setHandType("Flush");
			}
			else if(isStraight(i))
			{
				this.game.getPlayers()[i].getHand().setHandType("Straight");
			}
			else if(isTOAK(i) != -1)
			{
				this.game.getPlayers()[i].getHand().setHandType("Three of a Kind");
			}
			else if(isTwoPair(i))
			{
				this.game.getPlayers()[i].getHand().setHandType("Two Pair");
			}
			else if(isPair(i, -1) != -1)
			{
				this.game.getPlayers()[i].getHand().setHandType("Pair");
			}
			else
			{
				this.game.getPlayers()[i].getHand().setHandType("High Card");
			}
		}
	}
	
	/**
	 * A straight flush is a hand with a sequence the value of 5 cards
	 * as well as 5 cards of the same type. 
	 * 
	 * It is the best hand.
	 * 
	 * @param int - the index of player being checked
	 * @return true or false
	 */
	boolean isStraightFlush(int playerIndex)
	{
		if(isStraight(playerIndex))
		{
			if(isFlush(playerIndex))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * FOAK is four of the same value of cards in a hand. 
	 * 
	 * It is the second best hand.
	 * 
	 * @param int - the index of player being checked
	 * @return true or false
	 */
	boolean isFOAK(int playerIndex)
	{
		Hand currentHand = this.game.getPlayers()[playerIndex].getHand();
		
		int likeCount = 0;
		int placeHolder = currentHand.getHandCards()[0].getIntValue();
		
		for(int i = 0; i < currentHand.getHandSize() - 1; i++)
		{
			if(placeHolder != currentHand.getHandCards()[i + 1].getIntValue() && i < 1)
			{
				placeHolder = currentHand.getHandCards()[i + 1].getIntValue();
			}
			else if (placeHolder == currentHand.getHandCards()[i + 1].getIntValue())
			{
				likeCount++;
			}
			
			this.setIndexFOAK(i, playerIndex);
		}
		
		if(likeCount == 3)
		{
			return true;
		}
		
		this.setIndexFOAK(-1, playerIndex);
		return false;
	}
	
	/**
	 * A flush is 5 of the same card type. 
	 * 
	 * It is the fourth best hand.
	 * 
	 * @param int - the index of player being checked
	 * @return true or false
	 */
	boolean isFullHouse(int playerIndex)
	{
		int size = this.game.getPlayers()[playerIndex].getHand().getHandSize();
		int isTOAK = isTOAK(playerIndex);
		
		if(isTOAK != -1)
		{
			if(isTOAK - 2 > 0 || (size - 1) - (isTOAK) > 1)
			{
				if(isPair(playerIndex, isTOAK) != -1)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * A flush is 5 of the same card type. 
	 * 
	 * It is the fourth best hand.
	 * 
	 * @param int - the index of player being checked
	 * @return true or false
	 */
	boolean isFlush(int playerIndex)
	{
		Hand currentHand = this.game.getPlayers()[playerIndex].getHand();
		
		for(int i = 0; i < currentHand.getHandSize() - 1; i++)
		{
			if(currentHand.getHandCards()[0].getSuit() !=
					currentHand.getHandCards()[i + 1].getSuit())
			{
				return false;
			}
		}
			
		return true;
	}
	
	/**
	 * TOAK is three of the same kind of card values
	 * 
	 * It is the sixth best hand
	 * 
	 * @param int - the index of player being checked
	 * @return the index i of the TOAK or -1 if no TOAK is found
	 */
	boolean isStraight(int playerIndex)
	{
		Hand currentHand = this.game.getPlayers()[playerIndex].getHand();
		int straightCount = 0;
		int placeHolder = currentHand.getHandCards()[0].getIntValue();
		
		for(int i = 0; i < currentHand.getHandSize() - 1; i++)
		{
			if(currentHand.getHandCards()[i + 1].getIntValue() != placeHolder + 1)
			{
				return false;
			}
			straightCount++;
			placeHolder = currentHand.getHandCards()[i + 1].getIntValue();
		}
		
		if(straightCount == 4)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Two pair is when there are two different pairs in a hand, but no TOAK
	 * 
	 * It is the seventh best hand
	 * 
	 * @param int - the index of player being checked
	 * @return true or false
	 */
	int isTOAK(int playerIndex)
	{
		Hand currentHand = this.game.getPlayers()[playerIndex].getHand();
		
		int i = 0;
		while(i < currentHand.getHandSize() - 2)
		{
			if(currentHand.getHandCards()[i].getIntValue() != currentHand.getHandCards()[i + 2].getIntValue())
			{
				i++;
			}
			else if(currentHand.getHandCards()[i].getIntValue() == currentHand.getHandCards()[i + 1].getIntValue())
			{
				this.setIndexTOAK(i, playerIndex);
				return i;
			}
		}		
		
		this.setIndexTOAK(-1, playerIndex);
		return -1;
	}
	
	/**
	 * A pair is when a hand contains two cards of the same value, but no more.
	 * 
	 * The eighth best hand.
	 * 
	 * @param int - the index of player being checked
	 * @return the index i of the pair or -1 if no pair is found.
	 */
	boolean isTwoPair(int playerIndex)
	{
		Hand currentHand = this.game.getPlayers()[playerIndex].getHand();
		boolean isTwoPair = false;
		int pairs = 0;
		
		int i = 0;
		
		while(i < currentHand.getHandSize() - 1 && pairs < 2)
		{
			if(currentHand.getHandCards()[i].getIntValue() == currentHand.getHandCards()[i + 1].getIntValue())
			{
				if((i + 2) < currentHand.getHandSize() && currentHand.getHandCards()[i].getIntValue() == currentHand.getHandCards()[i + 2].getIntValue())
					{
						isTwoPair = false;
					}
				else
				{
					pairs++;
					if(pairs == 1)
					{
						this.setIndexLowerTwoPair(i, playerIndex);
					}
					
					if(pairs == 2)
					{
						this.setIndexHigherTwoPair(i, playerIndex);
					}
					i += 2;
				}
			}
			else
			{
				i++;
			}
		}
		
		if(pairs == 2)
		{
			isTwoPair = true;
		}
		
		return isTwoPair;
	}
	
	/**
	 * A high card results when there are no other types of hands that are present
	 * and the hand has to be ranked by the highest value card in the hand
	 * 
	 * The worst type of hand
	 * 
	 * @param int - the index of player being checked
	 * @return true or false
	 */
	int isPair(int playerIndex, int indexTOAK)
	{
		Hand currentHand = this.game.getPlayers()[playerIndex].getHand();
		int i; 
		
		// Set i based on position of potential THree of a Kind
		if(indexTOAK == -1)
		{
			i = 0;
		}
		else if (indexTOAK == 0)
		{
			i = indexTOAK + 3;
		}
		else
		{
			i = 0;
		}
		
		while(i < currentHand.getHandSize() - 1)
		{
			// Ignore pair with in three of a kind
			if(i == indexTOAK && i + 3 < currentHand.getHandSize())
			{
				i += 3;
			}
			else if(currentHand.getHandCards()[i].getIntValue() != currentHand.getHandCards()[i + 1].getIntValue())
			{
				i++;
			}
			else if(currentHand.getHandCards()[i].getIntValue() == currentHand.getHandCards()[i + 1].getIntValue())
			{
				this.setIndexPair(i, playerIndex);
				return i;
			}
		}		
		
		return -1;
	}
	
	/**
	 * This method finds the hand that has the highest valued card
	 * 
	 * @param first | Card[] - the first hand to be checked
	 * @param second | Card[] - the second hand to be checked
	 * @return 1 if second hand is highest, 0 if first hand is highest, or -1 for a tie
	 */
	public int findWhichHasHighest(Card[] first, Card[] second)
	{
		for(int i = first.length - 1; i > -1; i--)
		{
			if(first[i].getIntValue() < second[i].getIntValue())
			{
				return 1;
			}
			else if(first[i].getIntValue() > second[i].getIntValue())
			{
				return 0;
			}
		}
		
		return -1;
	}
	
	/**
	 * This method compares two integer values
	 * 
	 * @param first | Card[] - the first hand to be checked
	 * @param second | Card[] - the second hand to be checked
	 * @return 1 if second hand is highest, 0 if first hand is highest, or -1 for a tie
	 */
	public int compareTwoValues(int first, int second)
	{
		if(first < second)
		{
			return 1;
		}
		else if(first > second)
		{
			return 0;
		}
		
		return -1;
	}

	/**
	 * This method compares two cards in a hand
	 * starting at the given index
	 * 
	 * @param first | Card[] - the first hand to be checked
	 * @param second | Card[] - the second hand to be checked
	 * @param indexFirst | int - index of card in the first hand to be checked
	 * @param indexSecond | int - index of the card in the second hand to be checked
	 * @return 1 if second hand is highest, 0 if first hand is highest, or -1 for a tie
	 */
	public int compareTwoCards(Card[] first, Card[] second, int indexFirst, int indexSecond)
	{
		if(first[indexFirst].getIntValue() < second[indexSecond].getIntValue())
		{
			return 1;
		}
		else if(first[indexFirst].getIntValue() > second[indexSecond].getIntValue())
		{
			return 0;
		}
		
		return -1;
	}
	
	/**
	 * This method compares the hand value of the cards
	 * 
	 * @param first | Card[] - the first hand to be checked
	 * @param second | Card[] - the second hand to be checked
	 * @return 1 if second hand is highest, 0 if first hand is highest, or -1 for a tie
	 */
	public int compareTwoHands(Hand first, Hand second)
	{
		if(first.getHandIntValue() < second.getHandIntValue())
		{
			return 1;
		}
		else if(first.getHandIntValue() > second.getHandIntValue())
		{
			return 0;
		}
		
		return -1;
	}
	public void setGame(Game myGame)
	{
		this.game = myGame;
	}
	
	public void setIndexTOAK(int index, int player)
	{
		this.indexTOAK[player] = index;
	}
	
	public void setIndexFOAK(int index, int player)
	{
		this.indexFOAK[player] = index;
	}
	
	public void setIndexFHTOAK(int index, int player)
	{
		this.indexFHTOAK[player] = index;
	}
	
	public void setIndexFHPair(int index, int player)
	{
		this.indexFHPair[player] = index;
	}
	
	public void setIndexPair(int index, int player)
	{
		this.indexPair[player] = index;
	}
	
	public void setIndexHigherTwoPair(int index, int player)
	{
		this.indexHigherPair[player] = index;
	}
	
	public void setIndexLowerTwoPair(int index, int player)
	{
		this.indexLowerPair[player] = index;
	}
	
	public int getIndexTOAK(int player)
	{
		return this.indexTOAK[player];
	}
	
	public int getIndexFOAK(int player)
	{
		return this.indexFOAK[player];
	}
	
	public int getIndexFHTOAK(int player)
	{
		return this.indexFHTOAK[player];
	}
	
	public int getIndexFHPair(int player)
	{
		return this.indexFHPair[player];
	}
	
	public int getIndexPair(int player)
	{
		return this.indexPair[player];
	}
	
	public int getIndexHigherPair(int player)
	{
		return this.indexHigherPair[player];
	}
	
	public int getIndexLowerPair(int player)
	{
		return this.indexLowerPair[player];
	}
	
	
}
