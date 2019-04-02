package microservices.book.multiplication.multiplication.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Configures RabbitMQ to use events in our application.
 */
@Component
public class EventDispatcher {

	private RabbitTemplate rabbitTemplate;
	private String multiplicationExchange;
	private String multiplicationSolvedRoutingKey;

	@Autowired
	public EventDispatcher(final RabbitTemplate rabbitTemplate
			,
			@Value("${multiplication.exchange}") String multiplicationExchange,
			@Value("${multiplication.solved.key}") String multiplicationSolvedRoutingKey
			) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.multiplicationExchange = multiplicationExchange;
		this.multiplicationSolvedRoutingKey = multiplicationSolvedRoutingKey;
	}

	public void send(final MultiplicationSolvedEvent multiplicationSolvedEvent) {
		this.rabbitTemplate.convertAndSend(multiplicationExchange, multiplicationSolvedRoutingKey,
				multiplicationSolvedEvent);
	}
}
