package distance;

/**
 * A reporting class to record what measure and inputs were used, 
 * as well as the final distance calculated.
 * 
 * @author B Den Hartog
 *
 */ 
 public class DVPCalcResult {
  
	private String calcName;
	private double distance;
	private DistanceVectorPair inputs;
	
	public DVPCalcResult(String in_calcName, double in_distance, DistanceVectorPair in_inputs) {
		calcName = in_calcName;
		distance = in_distance;
		inputs = in_inputs;
	}
	
	public String getCalcName() {
		return calcName;
	}

	public double getDistance() {
		return distance;
	}

	public DistanceVectorPair getInputs() {
		return inputs;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Distance is ");
		sb.append(distance);
		sb.append(" for calculation type ");
		sb.append(calcName);
		sb.append("\n");
		sb.append(inputs.toString(30));
		return sb.toString();
	}
}
