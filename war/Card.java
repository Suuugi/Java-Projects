package war;

public class Card
{
	final static String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	final static String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private int suit;
	private int rank;

	public Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	public void setSuit(int suit)
	{
		if (suit < 4 && suit >= 0)
		{
			this.suit = suit;
		}
	}

	public int getSuit()
	{
		return suit;
	}

	public void setRank(int rank)
	{
		if (rank < 13 && rank >= 0)
		{
			this.rank = rank;
		}
	}

	public int getRank()
	{
		return rank;
	}

	@Override
	public String toString()
	{
		return RANKS[rank] + " of " + SUITS[suit];
	}
}
