package microservice.book.socialmultiplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

	@Autowired
	RandomGeneratorService service;

	@Test
	public void randomGeneratorServiceIsBetweenExpectedLimits() throws Exception {
		List<Integer> randomFactors = IntStream.range(0, 1000).map(i -> service.generateRandomFactor()).boxed()
				.collect(Collectors.toList());

		assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(1, 99).boxed().collect(Collectors.toList()));
	}
}
