package microservices.book.multiplication.multiplication.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import microservices.book.multiplication.multiplication.domain.Multiplication;
import microservices.book.multiplication.multiplication.service.MultiplicationService;

@RestController
@RequestMapping(value = "/multiplications")
public class MultiplicationController {

	private MultiplicationService service;
	private final int serverPort;
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	public MultiplicationController(MultiplicationService service, @Value("${server.port}") int serverPort) {
		this.service = service;
		this.serverPort = serverPort;
	}

	
	@GetMapping("/random")
	@HystrixCommand(fallbackMethod = "defaultRandomMultiplaction")
	public Multiplication getRandomMultiplication() {
		logger.info("Server port: {} | controller random multiplication: [{}*{}]", this.serverPort,
				service.createRandomMultiplication().getFactorA(), service.createRandomMultiplication().getFactorB());
		return service.createRandomMultiplication();
	}
	
	public Multiplication defaultRandomMultiplaction() {
		logger.info("Server port: {} | Fallback error: [{}*{}]", this.serverPort, 1,1);
		return new Multiplication(1,1);
	}
}
