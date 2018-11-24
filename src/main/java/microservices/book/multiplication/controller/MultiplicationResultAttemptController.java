package microservices.book.multiplication.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;

@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

	private final MultiplicationService multiplicationService;

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

	@Autowired
	public MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}

	@PostMapping
	public ResponseEntity<MultiplicationResultAttempt> postAttempt(
			@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
		boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
		logger.info("E' corretto: {}", isCorrect);
		MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(multiplicationResultAttempt.getUser(),
				multiplicationResultAttempt.getMultiplication(), multiplicationResultAttempt.getResultAttempt(),
				isCorrect);
		logger.info("Boolean parsato all'oggetto: {}}", attemptCopy.toString());
		return ResponseEntity.ok(attemptCopy);
	}

	@GetMapping
	ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
		return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
	}

	@GetMapping("/{resultId}")
	public ResponseEntity<MultiplicationResultAttempt> getResultById(@PathVariable("resultId") Long resultId) {
		return ResponseEntity.ok(multiplicationService.getResultById(resultId));
	}
}
