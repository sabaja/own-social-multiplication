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
	private final boolean correct;

	public MultiplicationResultAttempt() {
		this.multiplication = null;
		this.user = null;
		this.resultAttempt = -1;
		this.correct = false;
	}

}
