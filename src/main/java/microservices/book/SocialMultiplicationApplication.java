package microservices.book;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
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
