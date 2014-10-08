package problems.dice;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DiceProblemTest {
	IDiceProblem diceProblem;
	int dice, faces, trays, expectedResult;
	
	public DiceProblemTest (int dice, int faces, int trays, int result) {
			this.dice = dice;
			this.faces = faces;
			this.trays = trays;
			this.expectedResult = result;
	}
	
	 // creates the test data
	@Parameters
	public static Collection<Object[]> data() {
	    Object[][] data = new Object[][] { {3,4,3,19}, {2,6,2,17}, {3,6,3,77}, {2,4,2,9} };

	    return Arrays.asList(data);
	  }
	
	@Test
	public void testDiceProblem() {
		diceProblem = new DiceProblemOpt();
		diceProblem.setData(dice,faces,trays);
		diceProblem.run();
		int result = diceProblem.getResult();
		Assert.assertEquals("[dice:"+dice+",faces:"+faces+",trays:"+trays+"]: "
							, expectedResult, result );
	}
}