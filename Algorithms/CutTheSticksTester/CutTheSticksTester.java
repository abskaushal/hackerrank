import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;


public class CutTheSticksTester {


	int[] nullArray;
	static int[] emptyArray;
	static int[] shortArray;
	static int[] longArray;
	static int[] mixArray;
	static int[] zeroArray;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		//Initialize the test arrays
		emptyArray = new int[0];
		shortArray = new int[]{5, 4, 4, 2, 2, 8};
		longArray = new int[] {1, 2, 3, 4, 3, 3, 2, 1};
		mixArray = new int[] {1, 2, 3, -1, -6, 0, 3, 3, 2, 1};
		zeroArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
	}
	
	/**Test finding minimum element in given array
	 */
	@Test
	public  void testFindMinimum(){
		
		//Test Null array
		try {
			int nullMin = CutTheSticks.findMinimum(nullArray);
			fail("FindMinimum: check min of null array");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		//Test empty array
		try {
			int emptyMin = CutTheSticks.findMinimum(emptyArray);
			fail("FindMinimum: check min of empty array");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		//Test shortArray
		
		int minShortArray = CutTheSticks.findMinimum(shortArray);
		assertEquals("FindMinimumArray: check min of short array", 2, minShortArray);
		
		//Test longArray
		int minLongArray = CutTheSticks.findMinimum(longArray);
		assertEquals("FindMinimumArray: check min of long array", 1, minLongArray);
		
		//Test mixArray
		try {
			int minMixArray = CutTheSticks.findMinimum(mixArray);
			fail("FindMinimumArray: each stick's height must be +ive");
		} catch (IllegalArgumentException e) {
			
		}
		
		//Test zeroArray
		int minZeroArray = CutTheSticks.findMinimum(zeroArray);
		assertEquals("FindMinimumArray: check min of zero array", 0, minZeroArray);
		
	}
}
