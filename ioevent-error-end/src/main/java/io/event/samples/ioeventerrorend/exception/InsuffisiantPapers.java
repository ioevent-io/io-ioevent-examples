package io.event.samples.ioeventerrorend.exception;

public class InsuffisiantPapers extends RuntimeException{
	public InsuffisiantPapers(String message) {
        super(message);
    }

    public InsuffisiantPapers(String message, Throwable cause) {
        super(message, cause);
    }
}