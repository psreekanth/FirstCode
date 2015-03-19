public class OverdraftException extends Exception {
	private String error;
	public OverdraftException(String error) {
		this.error = error;
	}
}
