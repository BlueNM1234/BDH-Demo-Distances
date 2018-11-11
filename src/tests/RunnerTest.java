package tests;
/**
 * Test cases for the Runner class
 * 
 * @author B Den Hartog
 *
 */ 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import distance.ClusterShell;
import distance.DVPCalcResult;
import distance.DistanceFactory;
import distance.DistanceFactory.DistanceMeasure;
import distance.DistanceVectorPair;
import exceptions.DeprecatedMethodException;
import junit.framework.TestCase;

public class RunnerTest extends TestCase {
	List<String> ok1 = new ArrayList<String>(Arrays.asList("1", "3"));
	List<String> ok3 = new ArrayList<String>(Arrays.asList("3", "7"));

	DistanceVectorPair dvp1 = DistanceVectorPair.makePair(ok1, ok3);
	
	/**
	 * Test valid inputs on valid method and assert that the resulting distance is correct.
	 */
	public void testTaxi() {
		boolean thrown = false;
		try {
			ClusterShell cs = new ClusterShell(new DistanceFactory(DistanceMeasure.TAXICAB));
			DVPCalcResult dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(6.0, dist.getDistance(),.001);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			thrown = true;
		} catch (DeprecatedMethodException e) {
			System.out.println(e.getMessage());
		}
		assertFalse(thrown);
	}
	/**
	 * Test valid inputs on valid method and assert that the resulting distance is correct.
	 */
	public void testEuclid() {
		boolean thrown = false;
		try {
			ClusterShell cs = new ClusterShell(new DistanceFactory(DistanceMeasure.EUCLIDEAN));
			DVPCalcResult dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			thrown = true;
		} catch (DeprecatedMethodException e) {
			System.out.println(e.getMessage());
		}
		assertFalse(thrown);
	}
	
	/**
	 * Test valid inputs on valid method and assert that the resulting distance is correct.
	 * Uses default method (Euclidean)
	 */
	public void testDefault() {
		boolean thrown = false;
		try {
			ClusterShell cs = new ClusterShell(new DistanceFactory());
			DVPCalcResult dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			thrown = true;
		} catch (DeprecatedMethodException e) {
			System.out.println(e.getMessage());
		}
		assertFalse(thrown);
	}
	
	/**
	 * Test valid inputs on valid method and assert that the resulting distance is correct.
	 */
	public void testChebyshev() {
		boolean thrown = false;
		try {
			ClusterShell cs = new ClusterShell(new DistanceFactory(DistanceMeasure.CHEBYSHEV));
			DVPCalcResult dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4, dist.getDistance(),.001);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			thrown = true;
		} catch (DeprecatedMethodException e) {
			System.out.println(e.getMessage());
		}
		assertFalse(thrown);
	}
	
	/**
	 * Test a method that is no longer supported. Assert that DeprecatedMethodException is thrown.
	 */
	public void testDeprecated() {
		boolean thrown = false;
		try {
			ClusterShell cs = new ClusterShell(new DistanceFactory(DistanceMeasure.COSINE));
			DVPCalcResult dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (DeprecatedMethodException e) {
			System.out.println(e.getMessage());
			thrown = true;
		}
		assertTrue(thrown);
	}


	/**
	 * Test a null DistanceMeasure enum; verify that IllegalArgumentException occurs.
	 */
	public void testUnknown() {
		boolean thrown = false;
			
		try {
			ClusterShell cs = new ClusterShell(new DistanceFactory(null));
			DVPCalcResult dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(5.472, dist.getDistance(),.001);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			thrown = true;
		} catch (DeprecatedMethodException e) {
			System.out.println(e.getMessage());
		} 
		
		assertTrue(thrown);
	}
}
