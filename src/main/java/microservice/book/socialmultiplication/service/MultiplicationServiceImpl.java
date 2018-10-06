package microservice.book.socialmultiplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	private RandomGeneratorService randomGeneratorService;

	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
		super();
		this.randomGeneratorService = randomGeneratorService;
	}

	@Override
	public Multiplication createRandomMultiplication() {

		int factorA = this.randomGeneratorService.generateRandomFactor();
		int factorB = this.randomGeneratorService.generateRandomFactor();

		return new Multiplication(factorA, factorB);
	}

	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt multiplicationResultAttempt) {
		return multiplicationResultAttempt
				.getResultAttempt() == (multiplicationResultAttempt.getMultiplication().getFactorA())
						* (multiplicationResultAttempt.getMultiplication().getFactorB());
	}
}
