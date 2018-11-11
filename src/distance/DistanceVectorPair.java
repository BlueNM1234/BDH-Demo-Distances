package distance;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class DistanceVectorPair {
	private List<Double> vals1;
	private List<Double> vals2;

	/**
	 * This method is private to prevent any invalid constructions.
	 * Alternatively, the validation could be in this method and throw IllegalArgumentException.
	 * 
	 */
	   
	private DistanceVectorPair(List<Double> in_vals1, List<Double> in_vals2) 
	{
		vals1 = in_vals1;
		vals2 = in_vals2;
	}
			
	 /**
	   * This method is used to validate a pair of string vectors
	   * and, if they are all numeric values and of the same length,
	   * convert them and return a DistanceVectorPair. Otherwise return null.
	   * @param strVals1 The first input vector of strings
	   * @param strVals2 The second input vector of strings
	   * @return DistanceValuePair of the two inputs, or null if validation fails.
	   */
	public static DistanceVectorPair makePair(List<String> strVals1, List<String> strVals2) {
		List<Double> tvals1 = new ArrayList<Double>();
		List<Double> tvals2 = new ArrayList<Double>();
		Utils utils = new Utils();
		try {
			tvals1 = utils.build(strVals1);
			tvals2 = utils.build(strVals2);
			if (tvals1.size() != tvals2.size()) 
			{
				throw new IllegalArgumentException("Vectors must be of same size but first is (" + tvals1.size() + ") and second is (" + tvals2.size() + ") long.");
			}
			return new DistanceVectorPair(tvals1,  tvals2);
		} catch (IllegalArgumentException e) {
			System.out.println("Failed due to invalid arguments: " + e.getMessage());
			return null;
		} catch (Exception e){
			System.out.println("Failed : " + e.getMessage());
			return null;
		}
	}

	public int length() {
		//are guaranteed to be same 
		return vals1.size();
	}

	public double index1(int i) {
		if (i > -1 & i < vals1.size()) {
			return vals1.get(i);
		}
		throw new IllegalArgumentException("Cannot request index (" + i + ") for vector of length = " + vals1.size());
	}
	
	public double index2(int i) {
		if (i > -1 & i < vals2.size()) {
			return vals2.get(i);
		}
		throw new IllegalArgumentException("Cannot request index (" + i + ") for vector of length = " + vals2.size());
	}
	
	public String toString() {
		return toString(vals1.size());
	}	
	
	public String toString(int i) {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("\tInput1:");
		StringBuffer sb2 = new StringBuffer();
		sb2.append("\n\tInput2:");
		String sep = "";
		for (int idx = 0; idx < Math.min(i,  vals1.size()); ++idx)
		{
			sb1.append(sep);
			sb2.append(sep);
			sb1.append(index1(idx));
			sb2.append(index2(idx));
			sep = ",";
		}
		sb1.append(sb2.toString());
		return sb1.toString();
	}	
}
