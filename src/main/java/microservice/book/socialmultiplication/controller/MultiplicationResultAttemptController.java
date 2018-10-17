package microservice.book.socialmultiplication.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservice.book.socialmultiplication.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

	private MultiplicationService multiplicationService;
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * a good approach is to create a basic class that will wrap the result, by now
	 * consisting only of a boolean field: correct . Bear in mind that if you return
	 * a boolean directly in the response instead of wrapping it into a class, the
	 * default JSON serializer will not work.
	 * 
	 * Classe innestata che wrappa il risultato altrimenti con boolean non funziona:
	 * https://stackoverflow.com/questions/33185217/is-it-possible-in-spring-mvc-4-return-boolean-as-json
	 * 
	 */
	@RequiredArgsConstructor
	@NoArgsConstructor(force = true)
	@Getter
	@EqualsAndHashCode
	@ToString
	public final class ResultResponse {
		private final boolean check;
		private final int result;
	}

	@Autowired
	public MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}

	@PostMapping
	public ResponseEntity<ResultResponse> postAttempt(
			@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
		logger.info("Input from user (gui): ", multiplicationResultAttempt);
		boolean check = multiplicationService.checkAttempt(multiplicationResultAttempt);
		logger.info("E' corretto: {}", check);
		int result = multiplicationResultAttempt.getMultiplication().getResult();
		ResultResponse resultResponse = new ResultResponse(check,result);
		logger.info("Boolean parsato all'oggetto: {}}", resultResponse.toString());
		return ResponseEntity.ok(resultResponse);
	}
}