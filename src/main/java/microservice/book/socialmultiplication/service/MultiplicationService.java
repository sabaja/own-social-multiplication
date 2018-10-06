package microservice.book.socialmultiplication.service;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

	/**
	 * Create random multiplication between 1 to 99;
	 * @return
	 */
	public abstract Multiplication createRandomMultiplication();
	
	public abstract boolean checkAttempt(final MultiplicationResultAttempt multiplicationResultAttempt);
}
