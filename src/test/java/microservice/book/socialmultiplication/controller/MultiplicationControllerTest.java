package microservice.book.socialmultiplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.service.MultiplicationService;

@RunWith(SpringRunner.class)
// qui testiamo solo l'mvc non il servizio. Se testare Servizio allora usiamo
// testRestTemplate https://www.baeldung.com/spring-boot-testresttemplate
// o @SpringBootTest
@WebMvcTest(MultiplicationController.class)
public class MultiplicationControllerTest {

	@MockBean
	private MultiplicationService multiplicationService;

	@Autowired
	MockMvc mvc;

	private JacksonTester<Multiplication> json;

	// This object will be magically initialized by the initFields method below.
	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void getRandomMultiplicationTest() throws Exception {
		// Result Mock
		given(multiplicationService.createRandomMultiplication()).willReturn(new Multiplication(70, 20));

		// Http Response Mock
		MockHttpServletResponse response = mvc
				.perform(get("/multiplications/random").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		// asserzioni
		// assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
		Assert.assertEquals(200, response.getStatus());
		assertThat(response.getContentAsString()).isEqualTo(json.write(new Multiplication(70, 20)).getJson());
	}
}
