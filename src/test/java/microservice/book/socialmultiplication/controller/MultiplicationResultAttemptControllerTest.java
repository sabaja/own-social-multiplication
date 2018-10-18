package microservice.book.socialmultiplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservice.book.socialmultiplication.domain.User;
import microservice.book.socialmultiplication.service.MultiplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {

	@MockBean
	private MultiplicationService multiplicationService;

	@Autowired
	private MockMvc mvc;

	// These objects will be magically initialized by the initFields method below.
	private JacksonTester<MultiplicationResultAttempt> jsonResult;
	private JacksonTester<MultiplicationResultAttempt> jsonResponse;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void checkCorrectAttempt() throws Exception {
		this.genericParameterizedTest(true);
	}

	@Test
	public void checkWrongAttempt() throws Exception {
		this.genericParameterizedTest(false);
	}

	// Simula una chiamata http e ne verifica lo stato che sia 200
	private void genericParameterizedTest(final boolean correct) throws Exception {
		given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class))).willReturn(correct);
		User user = new User("john");
		Multiplication multiplication = new Multiplication(50, 70);
		MultiplicationResultAttempt attempt = null;
		attempt = correct ? new MultiplicationResultAttempt(multiplication, user, 3500, true)
				: new MultiplicationResultAttempt(multiplication, user, 350, false);

		// when
		MockHttpServletResponse response = mvc.perform(
				post("/results").contentType(MediaType.APPLICATION_JSON).content(jsonResult.write(attempt).getJson()))
				.andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(
				response.getContentAsString())
						.isEqualTo(
								jsonResponse
										.write(new MultiplicationResultAttempt(attempt.getMultiplication(),
												attempt.getUser(), attempt.getResultAttempt(), attempt.isCorrect()))
										.getJson());

	}
}
