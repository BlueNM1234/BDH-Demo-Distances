package distance;

import exceptions.DeprecatedMethodException;

public class ClusterShell {
	private DistanceFactory fact;
	
	public ClusterShell(DistanceFactory in_fact) {
		fact = in_fact;
	}
	public DVPCalcResult calculate(DistanceVectorPair d) throws DeprecatedMethodException, IllegalArgumentException 
	{
		return fact.makeDistanceCalculator().calculate(d);
	}
}
