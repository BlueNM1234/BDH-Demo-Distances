package distance;
/**
* This class represents the start of a clustering class.
* Using a factory for a specific distance measure,
* it creates a calculator and uses it when needed.
* 
* @author  Bobi Den Hartog
* 
*/
import exceptions.DeprecatedMethodException;

public class ClusterShell {
	private DistanceCalculator calc;
	
	public ClusterShell(DistanceFactory in_fact) throws IllegalArgumentException, DeprecatedMethodException {
		calc = in_fact.makeDistanceCalculator();
	}
	public DVPCalcResult calculate(DistanceVectorPair d) 
	{
		return calc.calculate(d);
	}
}
