package microservices.book.multiplication.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import microservices.book.multiplication.domain.Multiplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

	/**
	 * The @MockBean annotation is important in this test: it tells Spring to inject
	 * a mock of the RandomGeneratorService bean, instead of letting it search for a
	 * suitable implementation of the interface (which doesn’t exist yet). We’re
	 * using some benefits of both Mockito and Spring Boot to make a simple, concise
	 * unit test. We’re also using behavior-driven development (BDD, supported by
	 * MockitoBDD) to define what should happen when RandomGeneratorService is
	 * called. That makes the test even easier to read, which is great for the goal
	 * we have: getting help from the person defining our requirements to build the
	 * use cases. If we only write these three classes and execute the test, it will
	 * obviously fail, since there is no implementation of MultiplicationService to
	 * test. Again, that’s exactly the point of TDD—we wrote the specs first, then
	 * validate those with a business analyst (like a Product Owner in Scrum; see
	 * https://tpd.io/prd-own ), and then list which other cases should be covered.
	 * All of this with no implementation of the solution. Once the test
	 * (requirement) is clear, we write the solution, as shown in Listing 2-5 .
	 */
	@MockBean
	private RandomGeneratorService randomGeneratorService;

	@Autowired
	private MultiplicationService multiplicationService;

	@Test
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator service will return first 50, then 30)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

		// when
		Multiplication multiplication = multiplicationService.createRandomMultiplication();

		// assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		assertThat(multiplication.getResult()).isEqualTo(1500);
	}
}