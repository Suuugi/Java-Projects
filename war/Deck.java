package war;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	final static int DECK_COUNT = 52;
	final static int SUIT_COUNT = 4;
	final static int RANK_COUNT = 13;
	private ArrayList<Card> deck;

	public Deck()
	{
		deck = new ArrayList<Card>();
	}

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

	public Card draw()
	{
		if (deck.isEmpty())
		{
			return null;
		}
		else
		{
			return deck.remove(0);
		}
	}

	public void displayDeck()
	{
		System.out.println(toString());
	}

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

	public int getSize()
	{
		return deck.size();
	}
}
