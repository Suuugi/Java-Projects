/**
 * Write a program that prints the numbers from 1 to 100. But for multiples of
 * three print "Fizz" instead of the number and for the multiples of five print
 * "Buzz". For numbers which are multiples of both three and five print
 * "FizzBuzz".
 */
public class FizzBuzz
{
	public static void main(String[] args)
	{
		long nano;
		for (int j = 0; j < 100; j++)
		{
			nano = System.nanoTime();
			for (int i = 1; i < 101; i++)
			{
				if (i % 3 != 0 && i % 5 != 0)
				{
					System.out.print("");
				}
				else
				{
					if (i % 3 == 0)
					{
						System.out.print("");
					}
					if (i % 5 == 0)
					{
						System.out.print("");
					}
					System.out.print("");
				}
			}
			System.out.println(System.nanoTime()-nano);
		}
		System.out.println("------------");
		for (int j = 0; j < 100; j++)
		{
			nano = System.nanoTime();
			for (int i = 1; i < 101; i++)
			{
				if (i % 15 == 0)
				{
					System.out.print("");
				}
				else if (i % 3 == 0)
					{
						System.out.print("");
					}
				else if (i % 5 == 0)
					{
						System.out.print("");
					}
				else
				{
					System.out.print("");
				}
				System.out.print("");
			}
			System.out.println(System.nanoTime()-nano);
		}
	}
}