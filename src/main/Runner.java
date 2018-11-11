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
		List<String> ok1 = new ArrayList<String>(Arrays.asList("1", "3"));
		List<String> ok3 = new ArrayList<String>(Arrays.asList("3", "7"));

		DistanceVectorPair dvp1 = DistanceVectorPair.makePair(ok1, ok3);

		for (DistanceMeasure dm : DistanceFactory.DistanceMeasure.values())
		{
			try {
				ClusterShell cs = new ClusterShell(new DistanceFactory(dm));
				DVPCalcResult distance = cs.calculate(dvp1);
				System.out.println(distance.toString());
			} catch (DeprecatedMethodException e){ 
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
