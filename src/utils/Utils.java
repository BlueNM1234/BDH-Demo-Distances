package utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	
	public List<Double> build(List<String> strVals) 
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
//	https://www.baeldung.com/java-check-string-number
	private boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	} 
}
