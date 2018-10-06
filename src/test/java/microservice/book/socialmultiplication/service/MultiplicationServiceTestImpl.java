package microservice.book.socialmultiplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservice.book.socialmultiplication.domain.User;

public class MultiplicationServiceTestImpl {

	private MultiplicationServiceImpl multiplicationServiceImpl;

	@Mock
	private RandomGeneratorService randomGeneratorService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
	}

	@Test
	public void createApp() {
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

		// when
		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

		// assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
	}

	@Test
	public void checkCorrectAttemptResult() {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("Jack Black");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(multiplication, user, 3000);
	
		boolean result = multiplicationServiceImpl.checkAttempt(attempt);
		
		assertThat(result).isTrue();
	}
	
	@Test
	public void checkWrongAttemptResult() {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("Joe Black");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(multiplication, user, 3010);
	
		boolean result = multiplicationServiceImpl.checkAttempt(attempt);
		
		assertThat(result).isFalse();
	}


}
