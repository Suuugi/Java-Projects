package war;

/**
 * Card class simulates one of the many cards in a deck of playing cards. As
 * such, their suits and ranks are defined.
 */
public class Card
{
	/**
	 * The possible suits a card can have.
	 */
	final static String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	/**
	 * The possible ranks a card can have.
	 */
	final static String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	/**
	 * The suit value which corresponds to the suit array.
	 */
	private int suit;
	/**
	 * The rank value which corresponds to the rank array.
	 */
	private int rank;

	/**
	 * Card constructor initializes the suit and rank of the card.
	 * 
	 * @param suit
	 *            value of the card (should be 0-3)
	 * @param rank
	 *            value of the card (should be 0-12)
	 */
	public Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Set the suit variable.
	 * 
	 * @param suit
	 *            the new value of suit
	 */
	public void setSuit(int suit)
	{
		if (suit < 4 && suit >= 0)
		{
			this.suit = suit;
		}
	}

	/**
	 * Get the suit value.
	 * 
	 * @return the value of suit
	 */
	public int getSuit()
	{
		return suit;
	}

	/**
	 * Set the rank variable.
	 * 
	 * @param rank
	 *            the new value of rank
	 */
	public void setRank(int rank)
	{
		if (rank < 13 && rank >= 0)
		{
			this.rank = rank;
		}
	}

	/**
	 * Get the rank value.
	 * 
	 * @return the value of rank
	 */
	public int getRank()
	{
		return rank;
	}

	/**
	 * Override the toString so that you can see the card's suit and rank when
	 * outputting to the console.
	 */
	@Override
	public String toString()
	{
		return RANKS[rank] + " of " + SUITS[suit];
	}
}
