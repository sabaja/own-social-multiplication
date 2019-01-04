package microservices.book;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ComponentScan("microservice.book")
//@Configuration
//@EnableAutoConfiguration
public class SocialMultiplicationApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SocialMultiplicationApplication.class, args);
		System.out.println("Hit enter to terminate");
		System.in.read();
		context.close();
	}
}
