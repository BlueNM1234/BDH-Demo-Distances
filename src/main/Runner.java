package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import distance.ClusterShell;
import distance.DVPCalcResult;
import distance.DistanceFactory;
import distance.DistanceFactory.DistanceMeasure;
import distance.DistanceVectorPair;
import exceptions.DeprecatedMethodException;
/**
* Demonstrate the API for creating & calling a distance calculator.
* Inputs are bundled into DistanceVectorPairs and validated. 
* The distance measure is chosen from a predefined list.
* One distance measure has been deprecated, but is still included 
* for backward compatibility and throws a custom DeprecatedMethodException
* for the caller to handle as desired.
* 
* @author  Bobi Den Hartog
* 
*/

public class Runner {
	
	public static void main(String[] args) throws DeprecatedMethodException {
		//Set up example inputs
		List<String> ok1 = new ArrayList<String>(Arrays.asList("1", "3"));
		List<String> ok2 = new ArrayList<String>(Arrays.asList("1", "7"));
		List<String> ok3 = new ArrayList<String>(Arrays.asList("3", "7"));

		DistanceVectorPair dvp1 = DistanceVectorPair.makePair(ok1, ok2);
		DistanceVectorPair dvp2 = DistanceVectorPair.makePair(ok1, ok3);
		DistanceVectorPair[] dvps = {dvp1, dvp2};

		//For each defined Distance Measure
		for (DistanceMeasure dm : DistanceFactory.DistanceMeasure.values())
		{
			try {
				//Make a clusterer with a calculator for the distance measure
				ClusterShell cs = new ClusterShell(new DistanceFactory(dm));
				for (DistanceVectorPair dvp : dvps) {
					DVPCalcResult distance = cs.calculate(dvp);
					System.out.println(distance.toString());
				}
			// Catch any use of a deprecated distance measure
			} catch (DeprecatedMethodException e){ 
				System.out.println(e.getMessage());
			// Catch and display any other exception, to allow the rest of the processing to continue
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
