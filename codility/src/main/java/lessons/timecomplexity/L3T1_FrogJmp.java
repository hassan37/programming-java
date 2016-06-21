package lessons.timecomplexity;

import org.junit.Assert;
import org.junit.Test;


/**
 * Number of Jumps by Frog for given DISTANCE per jump D by difference formula
 * 
 * 
 * @see https://codility.com/programmers/task/frog_jmp/
 * @author hafiz.hassan
 *
 */
public class L3T1_FrogJmp {

	public int findMinJumps(int X, int Y, int D) {
		return (int) Math.ceil( ( (double)(Y-X)) / D);
	}
	
	@Test
	public void testMinJumps() {
		Assert.assertEquals(500000000, findMinJumps(0, 1000000000, 2));
		Assert.assertEquals(3, findMinJumps(10, 85, 30));
		
	}
}
