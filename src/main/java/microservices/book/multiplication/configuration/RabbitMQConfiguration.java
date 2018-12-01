package microservices.book.multiplication.configuration;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Configures RabbitMQ to use events in our application.
 */
@Configuration
public class RabbitMQConfiguration {

	/**
	 * To build a Topic Exchange 11111111
	 * 
	 * @param exchangeName
	 * @return
	 */
	@Bean
	public TopicExchange multiplicationExchange(@Value("${multiplication.exchange}") final String exchangeName) {
		return new TopicExchange(exchangeName);
	}

	/**
	 * Helper class for sending and receiving messages
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public MessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

//	@Bean
//	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
//		propertyPlaceholderConfigurer.setLocations(new ClassPathResource("application.properties"));
//		propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
//		return propertyPlaceholderConfigurer;
//	}
	/**
	 * per bloccare errore property
	 * https://stackoverflow.com/questions/48158249/spring-boot-could-not-resolve-placeholder-in-string
	 */
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//		c.setIgnoreUnresolvablePlaceholders(true);
//		return c;
//	}

}
