package utils;
/**
 * A convenience class to collect and reuse useful code
 * that doesn't isn't specific to a domain class.
 * 
 * @author B Den Hartog
 *
 */ 
import java.util.ArrayList;
import java.util.List;

public class Utils {

	/**
	 * Check that no element of the input is non-numeric. 
	 *  
	 * @param strVals A list of string values
	 * @return A list of Double values
	 * @throws IllegalArgumentException
	 */
	public List<Double> build(List<String> strVals) throws IllegalArgumentException
	{
		List<Double> doubleVals = new ArrayList<Double> ();
		
		for (String strVal : strVals){
			if (isNumeric(strVal)) {
				doubleVals.add(Double.parseDouble(strVal));
			} else {
				throw new IllegalArgumentException("Value of (" + strVal + ") must be a number.");
			}
		}
		return doubleVals;
	}
	/**
	 * Check that a string can be converted into a Double
	 * 
	 * From https://www.baeldung.com/java-check-string-number
	 *
	 * @param strNum An input string to test
	 * @return true if input is numeric, false otherwise
	 */
	private boolean isNumeric(String strNum) {
	    try {
	        Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	} 
}
