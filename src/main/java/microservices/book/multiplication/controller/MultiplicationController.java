package microservices.book.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;

@RestController
@RequestMapping(value="/multiplications")
public class MultiplicationController {
	
	private MultiplicationService service;

	@Autowired
	public MultiplicationController(MultiplicationService service) {
		this.service = service;
	}
	
	@GetMapping("/random")
	public Multiplication getRandomMultiplication() {
		return service.createRandomMultiplication();
	}
}
