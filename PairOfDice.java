/**
 * PairOfDice -- Uses methods from Die class to
 *  create a pair of dice.
 *  @author Joshua Hayes
 *  @since 2020-03-10
 */

/**
 * Creates a Pair of dice class
 */
public class PairOfDice
{
	private Die die1, die2;

	/**
	 * Constructor - Initializes 2 die objects
	 */
	public PairOfDice()
	{
		die1 = new Die();
		die2 = new Die();
	}

	/**
	 * Gets value of die 1.
	 * @return int
	 */
	public int getDie1Value()
	{
		return die1.getFaceValue();
	}

	/**
	 * Gets value of die 2.
	 * @return int
	 */
	public int getDie2Value()
	{
		return die2.getFaceValue();
	}

	/**
	 * Sets value of die 1 from param
	 * @param setDie
	 * @return No return value
	 */
	public void setDie1Value(int setDie)
	{
		die1.setFaceValue(setDie);
	}

	/**
	 * Sets value of die 2 from param
	 * @param setDie
	 * @return No return value
	 */
	public void setDie2Value(int setDie)
	{
		die2.setFaceValue(setDie);
	}

	/**
	 * Calculates sum of both die
	 * @return int
	 */
	public int sumOfDice()
	{
		return die1.getFaceValue() + die2.getFaceValue();
	}

	/**
	 * Rolls both die objects.
	 * @return int
	 */
	public int rollDice()
	{
		return die1.roll() + die2.roll();
	}
}
