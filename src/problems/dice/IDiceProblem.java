package problems.dice;

public interface IDiceProblem {
	/*
	 * This method sets the input data for the problem.
	 * @param dice the total number of dice.
	 * @param faces the number of faces each die has.
	 * @param trays the number of trays (units, tens, hundreds, etc.) the numbering system has.
	 * @throws IllegalArgumentException if any of the input parameters are zero or negative.
	 */
	public abstract void setData(int diceNumber, int faces, int trays);
	
	/*
	 * Executes the problem if the data has been correctly set
	 */
	public abstract void run();
	
	/*
	 * @return the first number that is impossible to be represented with the provided system.
	 */
	public abstract int getResult();
}