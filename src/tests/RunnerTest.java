package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.ClusterShell;
import main.DVPCalcResult;
import main.DistanceFactory;
import main.DistanceVectorPair;
import exceptions.UnimplementedMethodException;
import junit.framework.TestCase;

public class RunnerTest extends TestCase {
	List<String> ok1 = new ArrayList<String>(Arrays.asList("1", "3"));
	List<String> ok3 = new ArrayList<String>(Arrays.asList("3", "7"));

	DistanceVectorPair dvp1 = DistanceVectorPair.makePair(ok1, ok3);
	
	public void testTaxi() {
		boolean thrown = false;
		ClusterShell cs = new ClusterShell(new DistanceFactory("TX"));
		DVPCalcResult dist;
		try {
			dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(6.0, dist.getDistance(),0);
		} catch (UnimplementedMethodException e) {
			thrown = true;
		} 
		assertFalse(thrown);
	}

	public void testEuclid() {
		boolean thrown = false;
		ClusterShell cs = new ClusterShell(new DistanceFactory("EU"));
		DVPCalcResult dist;
		try {
			dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (UnimplementedMethodException e) {
			thrown = true;
		} 
		assertFalse(thrown);
	}

	public void testDefault() {
		//Euclid
		boolean thrown = false;
		ClusterShell cs = new ClusterShell(new DistanceFactory());
		DVPCalcResult dist;
		try {
			dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (UnimplementedMethodException e) {
			thrown = true;
		} 
		assertFalse(thrown);
	}

	public void testChebyshev() {
		boolean thrown = false;
		ClusterShell cs = new ClusterShell(new DistanceFactory("CH"));
		DVPCalcResult dist;
		try {
			dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.0, dist.getDistance(),0);
		} catch (UnimplementedMethodException e) {
			thrown = true;
		} 
		assertFalse(thrown);
	}

	public void testFuture() {
		boolean thrown = false;
		ClusterShell cs = new ClusterShell(new DistanceFactory("CS"));
		DVPCalcResult dist;
		try {
			dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (UnimplementedMethodException e) {
			System.out.println(e.getMessage());
			thrown = true;
		} 
		assertTrue(thrown);
	}

	public void testUnknown() {
		boolean thrown = false;
		ClusterShell cs = new ClusterShell(new DistanceFactory("XX"));
		DVPCalcResult dist;
		try {
			dist = cs.calculate(dvp1);
			System.out.println(dist.toString());
			assertEquals(4.472, dist.getDistance(),.001);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			thrown = true;
		} 
		assertTrue(thrown);
	}
}
