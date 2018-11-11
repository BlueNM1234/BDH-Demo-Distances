package tests;
/**
 * Test cases for the DistanceVectorPair class
 * 
 * @author B Den Hartog
 *
 */ 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import distance.DistanceVectorPair;
import junit.framework.TestCase;

public class DistanceVectorPairTest extends TestCase {
	List<String> ok1 = new ArrayList<String>(Arrays.asList("1", "3"));
	List<String> badchar1 = new ArrayList<String>(Arrays.asList("a", "3"));
	List<String> empty1 = new ArrayList<String>();
	List<String> null1 = null;
	List<String> ok2 = new ArrayList<String>(Arrays.asList("3", "3","5"));
	List<String> ok3 = new ArrayList<String>(Arrays.asList("3","5"));

	/**
	 * Accept numeric vectors, same length
	 */
	public void testGoodSameLength() {
		DistanceVectorPair dp = DistanceVectorPair.makePair(ok1,ok3);
		assertFalse(dp == null);
	}
	/**
	 * Reject numeric vectors of different lengths
	 */
	public void testGoodDifferentLength() {
		DistanceVectorPair dp = DistanceVectorPair.makePair(ok1,ok2);
		assertTrue(dp == null);
	}
	/**
	 * Reject vector with a non-numeric element
	 */
	public void testBadChar() {
		DistanceVectorPair dp = DistanceVectorPair.makePair(ok1,badchar1);
		assertTrue(dp == null);
	}
	/**
	 * Reject a null vector 
	 */
	public void testNullInput() {
		DistanceVectorPair dp = DistanceVectorPair.makePair(null1,ok1);
		assertTrue(dp == null);
	}
	/**
	 *  Accept numeric vectors, same length - special case where both are empty
	 */
	public void testBothEmpty() {
		DistanceVectorPair dp = DistanceVectorPair.makePair(empty1,empty1);
		assertFalse(dp == null);	
	}
}
