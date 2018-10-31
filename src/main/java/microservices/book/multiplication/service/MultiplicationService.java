package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

	/**
	 * Create random multiplication between 1 to 99;
	 * @return
	 */
	public abstract Multiplication createRandomMultiplication();
	
	public abstract boolean checkAttempt(final MultiplicationResultAttempt multiplicationResultAttempt);
}
