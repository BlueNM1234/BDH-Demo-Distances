package exceptions;
/**
 * Inform the user gracefully that the
 * method is no longer supported.
 * 
 * @author B Den Hartog
 *
 */ 
public class DeprecatedMethodException extends Exception {
	private static final long serialVersionUID = 1L;
	String type;
	public DeprecatedMethodException(String in_type) {
		type = in_type;
	}
	public String getMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append("Method no longer supported:");
		sb.append(type);
		return sb.toString();
	}

}
