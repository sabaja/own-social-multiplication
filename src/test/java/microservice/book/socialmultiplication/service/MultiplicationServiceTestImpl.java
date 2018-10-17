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

	//Verifica del corretto funzionamento del dominio
	@Test
	public void createApp() {
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

		// when
		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();
		User user = new User("Jack");
		MultiplicationResultAttempt resultAttempt = new MultiplicationResultAttempt(multiplication, user, multiplication.getResult(),false);
		// assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		assertThat(multiplication.getResult()).isEqualTo(1500);
		assertThat(user.getAlias()).isEqualTo("Jack");
		assertThat(resultAttempt).isNotNull();
		assertThat(resultAttempt.getResultAttempt()).isEqualTo(1500);
	}

	//Simuliamo un risultato corretto immesso da un utente
	@Test
	public void checkCorrectAttemptResult() {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("Jack Black");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(multiplication, user, 3000, true);

		boolean result = multiplicationServiceImpl.checkAttempt(attempt);

		assertThat(result).isTrue();
	}

	//Simuliamo un risultato sbagliato immesso da un utente
	@Test
	public void checkWrongAttemptResult() {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("Joe Black");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(multiplication, user, 3010, false);

		boolean result = multiplicationServiceImpl.checkAttempt(attempt);

		assertThat(result).isFalse();
	}

}
