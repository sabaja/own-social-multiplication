package microservices.book.multiplication.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;

@RestController
@RequestMapping(value = "/multiplications")
public class MultiplicationController {

	private MultiplicationService service;
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	public MultiplicationController(MultiplicationService service) {
		this.service = service;
	}

	@GetMapping("/random")
	public Multiplication getRandomMultiplication() {
		logger.debug("controller result: {}", service.createRandomMultiplication().getResult());
		return service.createRandomMultiplication();
	}
}
