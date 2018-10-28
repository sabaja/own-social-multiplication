package microservices.book.multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import microservices.book.multiplication.service.RandomGeneratorServiceImpl;

public class RandomGeneratorServiceImplTest {

	@SuppressWarnings("unused")
	private RandomGeneratorServiceImpl service;
	private static final int MIN = 1;
	private static final int MAX = 99;
	
	@Before
	public void setUp() {
		service = new RandomGeneratorServiceImpl();
	}
	
	@Test
	public void generateRandomMultiplicationService() throws Exception{
		List<Integer> ints = IntStream.range(MIN, MAX).boxed().collect(Collectors.toList());
		
		assertThat(ints).containsAnyElementsOf(IntStream.range(MIN, MAX).boxed().collect(Collectors.toList()));
 	}
}
