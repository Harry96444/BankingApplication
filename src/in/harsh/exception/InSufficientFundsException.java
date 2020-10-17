package in.harsh.exception;

import java.io.IOException;

public class InSufficientFundsException extends IOException {

	public InSufficientFundsException(String message) {
		super(message);
		
	}
}
