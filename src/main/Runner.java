package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.UnimplementedMethodException;

public class Runner {

	
	public static void main(String[] args) throws UnimplementedMethodException {
		List<String> ok1 = new ArrayList<String>(Arrays.asList("1", "3"));
		List<String> ok3 = new ArrayList<String>(Arrays.asList("3", "7"));
		
		DistanceVectorPair dvp1 = DistanceVectorPair.makePair(ok1, ok3);
		
		ClusterShell taxi = new ClusterShell(new DistanceFactory("TX"));
		DVPCalcResult taxiDistance= taxi.calculate(dvp1);
		System.out.println(taxiDistance.toString());
				
		ClusterShell euclid = new ClusterShell(new DistanceFactory("EU"));
		DVPCalcResult euclidDistance = euclid.calculate(dvp1);
		System.out.println(euclidDistance.toString());
		
		ClusterShell cheby = new ClusterShell(new DistanceFactory("CH"));
		DVPCalcResult chebyDistance = cheby.calculate(dvp1);
		System.out.println(chebyDistance.toString());
		
		
		
	
	}
}
