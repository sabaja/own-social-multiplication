package microservice.book.socialmultiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MultiplicationResultAttempt {

	private final Multiplication multiplication;
	private final User user;
	private final int resultAttempt;
	
	
	public MultiplicationResultAttempt() {
		this(null, null, -1);
	}
}
