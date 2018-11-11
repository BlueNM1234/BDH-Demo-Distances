package exceptions;

public class UnimplementedMethodException extends Exception {
	private static final long serialVersionUID = 1L;
	String type;
	public UnimplementedMethodException(String in_type) {
		type = in_type;
	}
	public String getMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append("Method not yet implemented:");
		sb.append(type);
		return sb.toString();
	}

}
