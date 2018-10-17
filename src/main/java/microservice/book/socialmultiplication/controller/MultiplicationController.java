package microservice.book.socialmultiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.service.MultiplicationService;

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
