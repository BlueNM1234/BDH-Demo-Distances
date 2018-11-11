package main;

import exceptions.UnimplementedMethodException;

public class ClusterShell {
	private DistanceFactory fact;
	
	public ClusterShell(DistanceFactory in_fact) {
		fact = in_fact;
	}
	public DVPCalcResult calculate(DistanceVectorPair d) throws UnimplementedMethodException 
	{
		return fact.makeDistanceCalculator().calculate(d);
	}
}
