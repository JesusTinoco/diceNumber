package problems.dice;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IDiceProblem diceProblem = new DiceProblemOpt();
		diceProblem.setData(1, 2, 2);	
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		diceProblem.run();
		time_end = System.currentTimeMillis();
		System.out.println(diceProblem.getResult());
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		
		
	}

}
