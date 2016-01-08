package war;

import java.util.ArrayList;

public class War
{
	private Deck deck;
	private ArrayList<Card> playOne;
	private ArrayList<Card> playTwo;
	private ArrayList<Card> warPile;

	public static void main(String[] args)
	{
		War war = new War();
		war.setGame();
		war.playGame();
	}

	public War()
	{
		deck = new Deck();
		playOne = new ArrayList<Card>();
		playTwo = new ArrayList<Card>();
		warPile = new ArrayList<Card>();
	}

	public void setGame()
	{
		deck.build();
		playOne.clear();
		playTwo.clear();
		warPile.clear();
		while (deck.getSize() != 0)
		{
			if (deck.getSize() != 0)
			{
				playOne.add(deck.draw());
			}
			if (deck.getSize() != 0)
			{
				playTwo.add(deck.draw());
			}
		}
	}

	public void playGame()
	{
		while (!playOne.isEmpty() && !playTwo.isEmpty())
		{
			compare();
		}
		System.out.println("GAME END");
		if (playOne.isEmpty())
		{
			System.out.println("Player 1 is out of cards!");
			System.out.println("Player 2 wins!");
		}
		else
		{
			System.out.println("Player 2 is out of cards!");
			System.out.println("Player 1 wins!");
		}
	}

	public void compare()
	{
		try
		{
			System.out.println("Player 1 plays(" + playOne.size() + "): " + playOne.get(0));
			System.out.println("Player 2 plays(" + playTwo.size() + "): " + playTwo.get(0));
			if (playOne.get(0).getRank() > playTwo.get(0).getRank())
			{
				System.out.println("Player 1 wins the round.");
				playOne.addAll(warPile);
				playOne.add(playTwo.remove(0));
				warPile.clear();
			}
			else if (playOne.get(0).getRank() < playTwo.get(0).getRank())
			{
				System.out.println("Player 2 wins the round.");
				playTwo.addAll(warPile);
				playTwo.add(playOne.remove(0));
				warPile.clear();
			}
			else
			{
				System.out.println("War!");
				for (int i = 0; i < 3; i++)
				{
					System.out.println("War card for player 1 is XX");
					System.out.println("War card for player 2 is XX");
					warPile.add(playOne.remove(0));
					warPile.add(playTwo.remove(0));
				}
			}
		}
		catch (IndexOutOfBoundsException iOOBE)
		{
			return;
		}
	}
}
