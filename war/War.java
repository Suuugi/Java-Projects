package war;

import java.util.ArrayList;

/**
 * Write a program that simulates the classic game of War. The game continues on
 * until one player is out of cards. Players are dealt the same amount of cards
 * and start by flipping over a card from the top. They are then compared. The
 * higher value (where Ace is the highest) gets the stack and adds it to the
 * bottom of their pile. In the event of a tie in card value, the game will go
 * into WAR. Three cards are dropped down from both players and then the fourth
 * card determines who gets the cards. In the event of one player not having
 * enough, the winner will be the one who has enough cards to finish the war. If
 * both players do not have enough cards, the one with available cards will win.
 * There are no ties in this game of War.
 */
public class War
{
	/**
	 * The deck of cards that will be dealt.
	 */
	private Deck deck;
	/**
	 * The first player's pile.
	 */
	private ArrayList<Card> playOne;
	/**
	 * The second player's pile.
	 */
	private ArrayList<Card> playTwo;
	/**
	 * The pile of the cards that pile up during the War.
	 */
	private ArrayList<Card> warPile;

	// Run the game
	public static void main(String[] args)
	{
		War war = new War();
		war.setGame();
		war.playGame();
	}

	/**
	 * War constructor defines all the ArrayLists so they can be filled.
	 */
	public War()
	{
		deck = new Deck();
		playOne = new ArrayList<Card>();
		playTwo = new ArrayList<Card>();
		warPile = new ArrayList<Card>();
	}

	/**
	 * Build the deck, clear all the piles, and then distribute the cards to
	 * each player.
	 */
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

	/**
	 * Keep comparing the cards until either player's pile is empty, then
	 * determine who is the winner based on who has cards (the loser would
	 * naturally not have cards).
	 */
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

	/**
	 * Attempt to play cards. This is where the card comparisons happen. Each
	 * time the warPile is added to the winner and cleared because in the event
	 * of a tie, War happens and three cards are dropped before calling compare
	 * again to determine where the cards will go. This is within a try block
	 * because there is a possibility of one player not having enough cards
	 * during a war, which would trigger the IndexOutOfBoundsException. When the
	 * exception is caught, the comparing is over and returns control back to
	 * the playGame method. The alternate/common way of the game ending is when
	 * one player is out of cards to which it will also fork over control back
	 * to that playGame method.
	 */
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
