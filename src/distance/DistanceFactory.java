package distance;

import exceptions.DeprecatedMethodException;
/**
 *  A class to return a calculator object based on the user's choice of 
 *  distance measure. Supported distance measures are listed in enum
 *  DistanceMeasure.
 *  Attempts to use a deprecated measure result in DeprecatedMethodException.
 *  
 * @author B Den Hartog
 *
 */
public class DistanceFactory {
	public enum DistanceMeasure  {
		EUCLIDEAN, TAXICAB, CHEBYSHEV, COSINE
	}
	//Default is Euclidean
	DistanceMeasure measure = DistanceMeasure.EUCLIDEAN;
	
	public DistanceFactory() {
	}
	
	public DistanceFactory(DistanceMeasure in_measure) throws IllegalArgumentException {
		measure = in_measure;
		if (measure == null){
			throw new IllegalArgumentException("Distance measure cannot be null.");
		}
	}
	/**
	 * Taxicab distance calculates the distance along the rows and columns of a grid or roads of a city, 
	 * no diagonals, one would have to travel to get from the start to the destination.
	 *
	 */
	private class TaxicabDistanceCalculator implements DistanceCalculator {

		 public DVPCalcResult calculate(DistanceVectorPair dvp) {
			double dist = 0;
			for (int idx = 0; idx < dvp.length(); ++idx) {
				dist += Math.abs(dvp.index1(idx) - dvp.index2(idx));
			}
			return new DVPCalcResult(measure.name(), dist, dvp);
		 }
	}
	
	/**
	 * Chebyshev distance calculates the greatest distance in any single dimension
	 * across the two position vectors.  The distance can be used in chess to represent the
	 * minimum number of moves a king would have to make to get to a destination. 
	 *
	 */
	private class ChebyshevDistanceCalculator implements DistanceCalculator {
		 public DVPCalcResult calculate(DistanceVectorPair dvp) {
			double dist = 0;
			for (int idx = 0; idx < dvp.length(); ++idx) {
				dist = Math.max(dist, Math.abs(dvp.index1(idx) - dvp.index2(idx)));
			}
			return new DVPCalcResult(measure.name(), dist, dvp);
		 }
	}
	/**
	 * Euclidean distance calculates the distance along a shortest path from the start 
	 * to the destination. This distance is sometimes called "as the crow flies" to indicate that
	 * it is not restricted by either grid elements or natural obstacles that a crow would simply fly over.
	 *
	 */
	private class EuclideanDistanceCalculator implements DistanceCalculator {
		 public DVPCalcResult calculate(DistanceVectorPair dvp) {
			double dist = 0;
			for (int idx = 0; idx < dvp.length(); ++idx) {
				double temp = dvp.index1(idx) - dvp.index2(idx);
				dist += temp*temp;
			}
			dist = Math.sqrt(dist);
			return new DVPCalcResult(measure.name(), dist, dvp);
		 }
	}
	/** Return a calculator object based on the user's choice of 
	 *  distance measure. Supported distance measures are listed in enum
	 *  DistanceMeasure.
	 *  Attempts to use a deprecated measure result in DeprecatedMethodException.
	 *  
	 *  @return Distance calculator of specified measure type
	 */
	public DistanceCalculator makeDistanceCalculator() throws DeprecatedMethodException, IllegalArgumentException {
	
		switch (measure){
			case EUCLIDEAN:
				return new EuclideanDistanceCalculator();
			case TAXICAB:
				return new TaxicabDistanceCalculator();
			case CHEBYSHEV:
				return new ChebyshevDistanceCalculator();
			case COSINE: 
				//Included for backward compatibility, but no longer supported.
				throw new DeprecatedMethodException(measure.name());
			default:
				throw new IllegalArgumentException("Type of calculator ( " + measure.name() + " ) not recognized");
		}
	}
}
