package microservices.book.multiplication.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

	@Override
	public int generateRandomFactor() {
		return ThreadLocalRandom.current().nextInt(1, 99);
	}

}
