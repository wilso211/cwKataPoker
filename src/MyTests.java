import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyTests {

	/**
	 * Tests a player 2 win with an Ace 
	 * high card
	 * 
	 */
	@Test
	public void testAceP2Win() {
		System.out.println();
		System.out.println("TEST: Player 2 Ace Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('2');
		cards1[1].setValue('3');
		cards1[2].setValue('5');
		cards1[3].setValue('9');
		cards1[4].setValue('K');
		
		cards1[0].setSuit("H");
		cards1[1].setSuit("D");
		cards1[2].setSuit("S");
		cards1[3].setSuit("C");
		cards1[4].setSuit("D");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('3');
		cards2[2].setValue('4');
		cards2[3].setValue('8');
		cards2[4].setValue('A');
		
		cards2[0].setSuit("C");
		cards2[1].setSuit("H");
		cards2[2].setSuit("S");
		cards2[3].setSuit("C");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(!tester.getPlayers()[0].getWinner());
		assertTrue(tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[1].getHand().getHandType() == "High Card");
	}
	
	/**
	 * Tests a Full House win for player 1
	 * 
	 */
	@Test
	public void testFullHP1Win() {
		System.out.println();
		System.out.println("TEST: Player 1 Full House Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('2');
		cards1[1].setValue('4');
		cards1[2].setValue('4');
		cards1[3].setValue('2');
		cards1[4].setValue('4');
		
		cards1[0].setSuit("H");
		cards1[1].setSuit("S");
		cards1[2].setSuit("C");
		cards1[3].setSuit("D");
		cards1[4].setSuit("H");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('8');
		cards2[2].setValue('A');
		cards2[3].setValue('Q');
		cards2[4].setValue('3');
		
		cards2[0].setSuit("S");
		cards2[1].setSuit("S");
		cards2[2].setSuit("S");
		cards2[3].setSuit("S");
		cards2[4].setSuit("S");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "Full House");
	}
	
	/**
	 * Tests a High Card 9 win for player 1
	 * 
	 */
	@Test
	public void test9P1Win() {
		System.out.println();
		System.out.println("TEST: Player 1 High Card 9 Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('2');
		cards1[1].setValue('3');
		cards1[2].setValue('5');
		cards1[3].setValue('9');
		cards1[4].setValue('K');
		
		cards1[0].setSuit("H");
		cards1[1].setSuit("D");
		cards1[2].setSuit("S");
		cards1[3].setSuit("C");
		cards1[4].setSuit("D");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('3');
		cards2[2].setValue('4');
		cards2[3].setValue('8');
		cards2[4].setValue('K');
		
		cards2[0].setSuit("C");
		cards2[1].setSuit("H");
		cards2[2].setSuit("S");
		cards2[3].setSuit("C");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "High Card");
	}
	
	/**
	 * Tests a tie
	 * 
	 */
	@Test
	public void testTie() {
		System.out.println();
		System.out.println("TEST: Test Tie");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('2');
		cards1[1].setValue('3');
		cards1[2].setValue('5');
		cards1[3].setValue('9');
		cards1[4].setValue('K');
		
		cards1[0].setSuit("H");
		cards1[1].setSuit("D");
		cards1[2].setSuit("S");
		cards1[3].setSuit("C");
		cards1[4].setSuit("D");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('3');
		cards2[2].setValue('5');
		cards2[3].setValue('9');
		cards2[4].setValue('K');
		
		cards2[0].setSuit("D");
		cards2[1].setSuit("H");
		cards2[2].setSuit("C");
		cards2[3].setSuit("S");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(!tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		assertTrue(tester.getPlayers()[0].getTie());
		assertTrue(tester.getPlayers()[1].getTie());
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "High Card");
		assertTrue(tester.getPlayers()[1].getHand().getHandType() == "High Card");
	}
	
	/**
	 * Tests a straight flush win for player 1
	 * 
	 */
	@Test
	public void testSFP1Win() {
		System.out.println();
		System.out.println("TEST: Player 1 Staight Flush Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('2');
		cards1[1].setValue('3');
		cards1[2].setValue('4');
		cards1[3].setValue('5');
		cards1[4].setValue('6');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("C");
		cards1[2].setSuit("C");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('Q');
		cards2[1].setValue('K');
		cards2[2].setValue('K');
		cards2[3].setValue('A');
		cards2[4].setValue('A');
		
		cards2[0].setSuit("S");
		cards2[1].setSuit("H");
		cards2[2].setSuit("D");
		cards2[3].setSuit("C");
		cards2[4].setSuit("S");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "Straight Flush");
	}
	
	/**
	 * Tests a straight flush win for player 2
	 * 
	 */
	@Test
	public void testSFP2Win() {
		System.out.println();
		System.out.println("TEST: Player 2 Straight Flush Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('7');
		cards1[1].setValue('3');
		cards1[2].setValue('4');
		cards1[3].setValue('5');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("C");
		cards1[2].setSuit("C");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('T');
		cards2[1].setValue('J');
		cards2[2].setValue('Q');
		cards2[3].setValue('K');
		cards2[4].setValue('A');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("H");
		cards2[2].setSuit("H");
		cards2[3].setSuit("H");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(!tester.getPlayers()[0].getWinner());
		assertTrue(tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[1].getHand().getHandType() == "Straight Flush");
	}
	
	/**
	 * Tests a three of a kind win for player 1
	 * 
	 */
	@Test
	public void testTOAKP1Win() {
		System.out.println();
		System.out.println("TEST: Player 1 Three Of A Kind Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('7');
		cards1[1].setValue('7');
		cards1[2].setValue('7');
		cards1[3].setValue('5');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("S");
		cards1[2].setSuit("H");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('T');
		cards2[1].setValue('J');
		cards2[2].setValue('T');
		cards2[3].setValue('K');
		cards2[4].setValue('A');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("H");
		cards2[2].setSuit("D");
		cards2[3].setSuit("D");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "Three of a Kind");
	}

	/**
	 * Tests a four of a kind win for player 2
	 * 
	 */
	@Test
	public void testFOAKP2Win() {
		System.out.println();
		System.out.println("TEST: Player 2 Four Of A Kind Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('7');
		cards1[1].setValue('7');
		cards1[2].setValue('7');
		cards1[3].setValue('5');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("S");
		cards1[2].setSuit("H");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('2');
		cards2[2].setValue('2');
		cards2[3].setValue('2');
		cards2[4].setValue('3');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("H");
		cards2[2].setSuit("D");
		cards2[3].setSuit("D");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(!tester.getPlayers()[0].getWinner());
		assertTrue(tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[1].getHand().getHandType() == "Four of a Kind");
	}
	
	/**
	 * Tests a flush win for player 2
	 * 
	 */
	@Test
	public void testFlushP2Win() {
		System.out.println();
		System.out.println("TEST: Player 2 Flush Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('5');
		cards1[1].setValue('6');
		cards1[2].setValue('7');
		cards1[3].setValue('8');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("S");
		cards1[2].setSuit("H");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('2');
		cards2[2].setValue('2');
		cards2[3].setValue('5');
		cards2[4].setValue('3');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("H");
		cards2[2].setSuit("H");
		cards2[3].setSuit("H");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(!tester.getPlayers()[0].getWinner());
		assertTrue(tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[1].getHand().getHandType() == "Flush");
	}
	
	/**
	 * Tests a straight win for player 1
	 * 
	 */
	@Test
	public void testStraightP1Win() {
		System.out.println();
		System.out.println("TEST: Player 1 Straight Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('5');
		cards1[1].setValue('6');
		cards1[2].setValue('7');
		cards1[3].setValue('8');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("S");
		cards1[2].setSuit("H");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('2');
		cards2[2].setValue('2');
		cards2[3].setValue('5');
		cards2[4].setValue('3');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("C");
		cards2[2].setSuit("H");
		cards2[3].setSuit("H");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "Straight");
	}
	
	/**
	 * Tests a pair win for player 1
	 * 
	 */
	@Test
	public void testPairP1Win() {
		System.out.println();
		System.out.println("TEST: Player 1 Pair Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('5');
		cards1[1].setValue('5');
		cards1[2].setValue('7');
		cards1[3].setValue('8');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("S");
		cards1[2].setSuit("H");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('2');
		cards2[2].setValue('4');
		cards2[3].setValue('5');
		cards2[4].setValue('3');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("C");
		cards2[2].setSuit("H");
		cards2[3].setSuit("H");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(tester.getPlayers()[0].getWinner());
		assertTrue(!tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[0].getHand().getHandType() == "Pair");
	}
	
	/**
	 * Tests a two pair win for player 1
	 * 
	 */
	@Test
	public void testToPairP2Win() {
		System.out.println();
		System.out.println("TEST: Player 2 Two Pair Win");
		System.out.println("------------------------------");
		
		Game tester = new Game();
		
		Hand t1 = new Hand();
		Hand t2 = new Hand();
		
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		
		for(int i = 0; i < 5; i++)
		{
			cards1[i] = new Card();
			cards2[i] = new Card();
		}
		
		// Test player 1
		cards1[0].setValue('5');
		cards1[1].setValue('5');
		cards1[2].setValue('7');
		cards1[3].setValue('8');
		cards1[4].setValue('9');
		
		cards1[0].setSuit("C");
		cards1[1].setSuit("S");
		cards1[2].setSuit("H");
		cards1[3].setSuit("C");
		cards1[4].setSuit("C");
		
		// Test player 2
		cards2[0].setValue('2');
		cards2[1].setValue('2');
		cards2[2].setValue('4');
		cards2[3].setValue('4');
		cards2[4].setValue('3');
		
		cards2[0].setSuit("H");
		cards2[1].setSuit("C");
		cards2[2].setSuit("H");
		cards2[3].setSuit("H");
		cards2[4].setSuit("H");
		
		t1.setHandSize(5);
		t2.setHandSize(5);

		t1.setHandCards(cards1);
		t2.setHandCards(cards2);
		
		tester.setUpGame();
		tester.dealPlayerHands();
		tester.getPlayers()[0].setHand(t1);
		tester.getPlayers()[1].setHand(t2);
		tester.sortHandsByValue();
		tester.outputPlayerHands();
		tester.findWinner();
		tester.outputPlayerHandType();
		tester.outputWinner();
		
		assertTrue(!tester.getPlayers()[0].getWinner());
		assertTrue(tester.getPlayers()[1].getWinner());
		
		assertTrue(tester.getPlayers()[1].getHand().getHandType() == "Two Pair");
	}
}
