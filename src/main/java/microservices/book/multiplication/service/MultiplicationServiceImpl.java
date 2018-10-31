package microservices.book.multiplication.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.repository.MultiplicationResultAttemptRepository;
import microservices.book.multiplication.repository.UserRepository;

@Service
@SuppressWarnings("unused")
public class MultiplicationServiceImpl implements MultiplicationService {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private RandomGeneratorService randomGeneratorService;
	private MultiplicationResultAttemptRepository attemptRepository;
	private UserRepository userRepository;

	public MultiplicationServiceImpl() {
	}
	
	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
		super();
		this.randomGeneratorService = randomGeneratorService;
	}

	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService, MultiplicationResultAttemptRepository attemptRepository, UserRepository userRepository) {
		super();
		this.randomGeneratorService = randomGeneratorService;
		this.attemptRepository = attemptRepository;
		this.userRepository = userRepository;
	}
	
	@Override
	public Multiplication createRandomMultiplication() {

		int factorA = this.randomGeneratorService.generateRandomFactor();
		int factorB = this.randomGeneratorService.generateRandomFactor();

		return new Multiplication(factorA, factorB);
	}

	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt attempt) {

		boolean correct = attempt.getResultAttempt() == (attempt.getMultiplication().getFactorA())
				* (attempt.getMultiplication().getFactorB());
		
		// Avoids 'hack' attempts
//        Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");

        MultiplicationResultAttempt checkedResult = new MultiplicationResultAttempt(attempt.getUser(), attempt.getMultiplication(), attempt.getResultAttempt(), correct);
		logger.info("E' giusta la moltiplicazione? {}", checkedResult.toString());
		return correct;
	}
}
