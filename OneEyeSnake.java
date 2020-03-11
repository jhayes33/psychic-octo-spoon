/**
 * 1. Rolls 2 dice.
 * 2. Calculates sum of both dice for round and total.
 * 3. If user rolls a 1 or user inputs hold, their turn is over.
 * 4. Computer rolls until round total is atleast 20 or until a 1 is rolled.
 * 5. First to reach at least 30 points wins.
 */

/**
 * OneEyeSnake -- Game between user and computer in which
 * first player to reach 30 wins.
 * @author Joshua Hayes
 * @version 2.0
 * @since 2020-03-10
 */

import java.util.Scanner;

public class OneEyeSnake
{
	/**
	 * Main driver program
	 * @param arg A string array containing
	 * the command line arguements.
	 * @exception Any exception.
	 * @return No return value.
	 */

	public static void main(String[] args)
	{
		PairOfDice twoDice;
		twoDice = new PairOfDice();

		Scanner scan = new Scanner(System.in);
		
		int humanTotal, computerTotal,potentialTotal,currentTotal;
		humanTotal = 0; // User's total
		computerTotal = 0; //Computer's Total

		while ( humanTotal < 30 && computerTotal < 30) //While neither has reached 30pts
		{
			System.out.println("Your turn");
			System.out.println("Current Status: ");
			System.out.println("	Computer: " + computerTotal);
			System.out.println("	You: " + humanTotal);
			boolean turnOver = false; //Flag, indicates when turn is over
			currentTotal = 0; // Holds round sum


			while(turnOver == false && computerTotal < 30) // Players turn 
			{

				potentialTotal = humanTotal + currentTotal; //Past+present total
				twoDice.rollDice();

				System.out.println("Die 1:" + twoDice.getDie1Value()
						+"	"
						+ "Die 2: " + twoDice.getDie2Value());
				//If user rolls a 1 with either die, turn is over
				if (twoDice.getDie1Value() == 1 || twoDice.getDie2Value() == 1)
				{
					System.out.println("Busted!!!");
					turnOver = true;

				}
				else
				{
					currentTotal += twoDice.sumOfDice();
					potentialTotal = humanTotal + currentTotal;
					
					System.out.println("Current Round: "
						       	+ currentTotal);
					System.out.println("Potential Total: " +
						potentialTotal);
					if(potentialTotal >= 30) //User wins
					{
						turnOver = true;

						humanTotal = potentialTotal;
						System.out.println("\nCongratulations,"
								+" You win!!!\n");

						System.out.println("Final Results: ");
						System.out.println("\tComputer: "
								+ computerTotal);
						System.out.println("\tYou: "
								+ humanTotal);

						
					}
					else //Does user want to continue
					{System.out.print("Take another turn (y/n)? ");
					
					char done = scan.next().charAt(0);
					if ( done != 'y')
						{turnOver = true;
						humanTotal = potentialTotal;
						}
					}

				}

			}
			if(humanTotal < 30)//Shows score if game still is in session
			{
			System.out.println("******************************************");

			System.out.println("Computer's Turn");
			System.out.println("Current Status: ");
			System.out.println("	Computer: " + computerTotal);
			System.out.println("	You: " + humanTotal);
			
			turnOver = false;
			currentTotal = 0;
			}

			while(turnOver == false && humanTotal < 30)//Computers turn
			{
				potentialTotal = computerTotal + currentTotal;
				twoDice.rollDice();

				System.out.println("Die 1:" + twoDice.getDie1Value()
						+"	"
						+ "Die 2: " + twoDice.getDie2Value());
				//If computer rolls a 1 on either die
				if (twoDice.getDie1Value() == 1 || twoDice.getDie2Value() == 1)
				{
					System.out.println("Busted!!!");
					turnOver = true;

				}
			
				else
				{
					currentTotal += twoDice.sumOfDice();//Past+Current total
					potentialTotal = computerTotal + currentTotal;

					System.out.println("Current Round: "
						       	+ currentTotal);
					System.out.println("Potential Total: " +
						potentialTotal);
					if( potentialTotal >= 30) //Computer wins
					{
						turnOver = true;
						
						computerTotal = potentialTotal;
						System.out.println("\nThe computer has won!\n");
						
						System.out.println("Final Results: ");
						System.out.println("\tComputer: " 
								+ computerTotal);
						System.out.println("\tYou: : "
								+ humanTotal);
					}
					else
					{
					System.out.println("Current Round: "
						       	+ currentTotal);
					System.out.println("Potential Total: " +
						potentialTotal);

					if ( currentTotal >= 20)//Computer holds if has 20pts
					{
						turnOver = true;
						computerTotal = potentialTotal;
					}
					}
				}
			}
			System.out.println("******************************************");

		}

	}
}
