package tests;

import problems.dice.DiceProblemOpt;
import problems.dice.IDiceProblem;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IDiceProblem diceProblem = new DiceProblemOpt();
		diceProblem.setData(5, 10, 1);	
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		diceProblem.run();
		time_end = System.currentTimeMillis();
		System.out.println(diceProblem.getResult());
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		
		
	}

}
