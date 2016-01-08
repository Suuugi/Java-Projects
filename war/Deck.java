package war;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Simulates a deck of cards. When created and built, it will have 52 cards
 * according to the different COUNT variables.
 */
public class Deck
{
	/**
	 * The size of a standard deck of cards.
	 */
	final static int DECK_COUNT = 52;
	/**
	 * The number of suits which correspond to the amount in the Card class.
	 */
	final static int SUIT_COUNT = 4;
	/**
	 * The number of ranks which correspond to the amount in the Card class.
	 */
	final static int RANK_COUNT = 13;
	/**
	 * Where the Cards are being stored once they are defined.
	 */
	private ArrayList<Card> deck;

	/**
	 * Default Deck constructor which defines the ArrayList of Cards.
	 */
	public Deck()
	{
		deck = new ArrayList<Card>();
	}

	/**
	 * Clears the deck before populating and shuffling the 52 playing cards.
	 */
	public void build()
	{
		deck.clear();
		for (int i = 0; i < SUIT_COUNT; i++)
		{
			for (int j = 0; j < RANK_COUNT; j++)
			{
				deck.add(new Card(i, j));
			}
		}
		Collections.shuffle(deck);
	}

	/**
	 * Return a card from the deck. If the deck is empty, throw
	 * IndexOutOfBoundsException.
	 * 
	 * @return a card from the deck
	 */
	public Card draw()
	{
		return deck.remove(0);
	}

	/**
	 * toString override to display how many cards in the deck and then proceeds
	 * to show what cards are in the deck.
	 */
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("There are " + deck.size() + " cards in the deck.\n");
		for (int i = 0; i < deck.size(); i++)
		{
			str.append((i + 1) + ") " + deck.get(i) + "\n");
		}
		return str.toString();
	}

	/**
	 * Return the size of the deck.
	 * 
	 * @return the deck size
	 */
	public int getSize()
	{
		return deck.size();
	}
}
