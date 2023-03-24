package ioevent.sample.exception;

public class CreditCardTransactionFailure extends RuntimeException{
	public CreditCardTransactionFailure(String message) {
        super(message);
    }

    public CreditCardTransactionFailure(String message, Throwable cause) {
        super(message, cause);
    }
}
