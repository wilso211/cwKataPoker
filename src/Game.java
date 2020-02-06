/**
 * Game is the driver class for the Kata Poker
 * comparison application. It initiates the game
 * and calls all other classes. 
 * 
 * @author Cecil Wilson
 *
 */

public class Game {

	/**
	 * The number of players in the game
	 */
	private int numPlayers = 2;
	
	/**
	 * The size of the hand each player has
	 */
	private int handSize = 5;
	
	private Dealer dealer;
	private Player[] players;
	private Compare comparer;
	private Sorter sorter;
	private Output outputter;

	public static void main(String args[])
	{
		// Set up game
		Game myGame = new Game();
		myGame.setUpGame();
		myGame.shuffle();
		myGame.dealPlayerHands();
		myGame.sortHandsByValue();
		myGame.outputPlayerHands();
		myGame.findWinner();
		myGame.outputPlayerHandType();
		myGame.outputWinner();
		
	}
	
	Game()
	{
		
	}
	
	/**
	 * 
	 * This method creates the players,
	 * dealer, and initiates the deck.
	 * It also creates the compare, sort,
	 * and output objects
	 * 
	 * 
	 */
	public void setUpGame()
	{
		Player[] players = new Player[numPlayers];
		for(int i = 0; i < this.numPlayers; i++)
		{
			players[i] = new Player();
		}
		this.players = players;
		
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		
		dealer.setDeck(deck.createDeck());
		
		this.dealer = dealer;
		
		Sorter sorter = new Sorter();
		this.sorter = sorter;
		
		Compare comparer = new Compare(this.numPlayers);
		
		this.comparer = comparer;
		this.comparer.setGame(this);
		
		Output outputter = new Output();
		
		this.outputter = outputter;
		
	}
	
	/*
	 * This method is used to initiate the
	 * shuffling of the deck
	 * 
	 */
	public void shuffle()
	{
		this.dealer.shuffleCards();
	}
	
	/**
	 * This method initiates dealing
	 * of player hands
	 * 
	 */
	public void dealPlayerHands()
	{
		this.dealer.createPlayerHand(this.handSize, this.numPlayers, this.players);
		
	}
	
	/**
	 * This method sorts the player's
	 * hands by value from lowest to
	 * highest.
	 */
	public void sortHandsByValue()
	{
		for(int i = 0; i < this.numPlayers; i++)
		{
			this.sorter.sortCardsByValue(this.getPlayers()[i].getHand().getHandCards());
		}
	}
	
	/**
	 * This method initiates the comparing
	 * of player hands in order find the
	 * hand type and declare if a hand
	 * is the winner.
	 * 
	 */
	public void findWinner()
	{
		this.comparer.compareHands();
	}
		
	/*
	 * This method simply prints
	 * out the deck.
	 * 
	 */
	public void outputDeck()
	{
		this.outputter.printDeck(this.getDealer().getDeck());
	}
	
	/**
	 * This method simply prints
	 * out the player hands
	 * 
	 */
	public void outputPlayerHands()
	{
		for(int i = 0; i < this.getPlayers().length; i++)
		{
			System.out.print("Player " + (i + 1) + ": ");
			this.outputter.printHand(this.getPlayers()[i].getHand().getHandCards());
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * This method simply prints out 
	 * the type of hand a player has
	 * [Ex. "Straight" or "Pair"]
	 * 
	 */
	public void outputPlayerHandType()
	{
		for(int i = 0; i < this.getPlayers().length; i++)
		{
			System.out.print("Player " + (i + 1) + ": ");
			this.outputter.printHandType(this.getPlayers()[i].getHand());
			System.out.println();
		}
	}
	
	/**
	 * This method simply prints out 
	 * which player is the winner
	 * or if it was a tie
	 * 
	 */
	public void outputWinner()
	{
		for(int i = 0; i < this.getPlayers().length; i++)
		{
			if(this.getPlayers()[i].getWinner())
			{
				this.outputter.printWinner(i, this.getPlayers()[i].getHand());
			}
			if(this.getPlayers()[i].getTie())
			{
				this.outputter.printTie();
				break;
			}
		}
	}
	
	public void setPlayers(Player[] players)
	{
		this.players = players;
	}
	
	public void setDealer(Dealer dealer)
	{
		this.dealer = dealer;
	}

	public void setComparer(Compare comparer)
	{
		this.comparer = comparer;
	}
	
	public void setSorter(Sorter sorter)
	{
		this.sorter = sorter;
	}
	
	public Player[] getPlayers()
	{
		return this.players;
	}
	
	public Dealer getDealer()
	{
		return this.dealer;
	}
	
	public Compare getComparer()
	{
		return this.comparer;
	}
	
	public Sorter getSorter()
	{
		return this.getSorter();
	}
}
