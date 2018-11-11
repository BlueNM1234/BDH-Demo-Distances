package main;

import exceptions.UnimplementedMethodException;


public class DistanceFactory {
	//Default is Euclidean
	String type = "EU";
	
	public DistanceFactory() {
	}
	
	public DistanceFactory(String in_type) {
		type = in_type;
	}
	
	private class TaxicabDistanceCalculator implements DistanceCalculator {
		 private String name = "Taxicab";
		 public DVPCalcResult calculate(DistanceVectorPair dvp) {
			double dist = 0;
			for (int idx = 0; idx < dvp.length(); ++idx) {
				dist += Math.abs(dvp.index1(idx) - dvp.index2(idx));
			}
			return new DVPCalcResult(name, dist, dvp);
		 }
	}
	
	private class ChebyshevDistanceCalculator implements DistanceCalculator {
		 private String name = "Chebyshev";
		 public DVPCalcResult calculate(DistanceVectorPair dvp) {
			double dist = 0;
			for (int idx = 0; idx < dvp.length(); ++idx) {
				dist = Math.max(dist, Math.abs(dvp.index1(idx) - dvp.index2(idx)));
			}
			return new DVPCalcResult(name, dist, dvp);
		 }
	}
	
	private class EuclideanDistanceCalculator implements DistanceCalculator {
		 private String name = "Euclidean";
		 public DVPCalcResult calculate(DistanceVectorPair dvp) {
			double dist = 0;
			for (int idx = 0; idx < dvp.length(); ++idx) {
				double temp = dvp.index1(idx) - dvp.index2(idx);
				dist += temp*temp;
			}
			dist = Math.sqrt(dist);
			return new DVPCalcResult(name, dist, dvp);
		 }
	}
	
	public DistanceCalculator makeDistanceCalculator() throws UnimplementedMethodException {
		switch (type){
			case "EU":
				return new EuclideanDistanceCalculator();
			case "TX":
				return new TaxicabDistanceCalculator();
			case "CH":
				return new ChebyshevDistanceCalculator();
			case "CS": 
				//Imagine that this is planned for a future release.
				throw new UnimplementedMethodException("CS (Cosine)");
			default:
				throw new IllegalArgumentException("Type of calculator ( " + type + " ) not recognized");
		}
	}
}
