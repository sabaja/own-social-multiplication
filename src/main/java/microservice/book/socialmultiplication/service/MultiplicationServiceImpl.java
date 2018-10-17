package microservice.book.socialmultiplication.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
	

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
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
		
		logger.info("fattore a: {}", multiplicationResultAttempt.getMultiplication().getFactorA());
		logger.info("fattore b: {}", multiplicationResultAttempt.getMultiplication().getFactorB());
		logger.info("moltiplicazione: {}", (multiplicationResultAttempt.getMultiplication().getFactorA())
				* (multiplicationResultAttempt.getMultiplication().getFactorB()));
		logger.info("oggetto multiplicationResultAttempt result: {}",multiplicationResultAttempt
				.getResultAttempt());
		boolean check = multiplicationResultAttempt
		.getResultAttempt() == (multiplicationResultAttempt.getMultiplication().getFactorA())
				* (multiplicationResultAttempt.getMultiplication().getFactorB());
		logger.info("E' giusta la moltiplicazione? {}", check);
		return check;
	}
}
