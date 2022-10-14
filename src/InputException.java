// Class that cathces a wrong input by the user in the API

public class InputException extends RuntimeException {

	private static final long serialVersionUID = 575262834263843711L;

	public InputException(String reason) {
		super(reason);
	}
}