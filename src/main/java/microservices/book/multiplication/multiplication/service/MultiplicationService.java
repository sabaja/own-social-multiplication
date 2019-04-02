package microservices.book.multiplication.multiplication.service;

import java.util.List;

import microservices.book.multiplication.multiplication.domain.Multiplication;
import microservices.book.multiplication.multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

	/**
	 * Creates a Multiplication object with two randomly-generated factors between
	 * 11 and 99.
	 *
	 * @return a Multiplication object with random factors
	 */
	Multiplication createRandomMultiplication();

	/**
	 * @return true if the attempt matches the result of the multiplication, false
	 *         otherwise.
	 */
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

	/**
	 * Gets the statistics for a given user.
	 *
	 * @param userAlias the user's alias
	 * @return a list of {@link MultiplicationResultAttempt} objects, being the past
	 *         attempts of the user.
	 */
	List<MultiplicationResultAttempt> getStatsForUser(final String userAlias);

	/**
	 * 
	 * @param resultId of {@link MultiplicationResultAttempt}
	 * @return a {@link MultiplicationResultAttempt}
	 */
	MultiplicationResultAttempt getResultById(Long resultId);
}
