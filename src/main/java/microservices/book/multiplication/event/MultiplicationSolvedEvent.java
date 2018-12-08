package microservices.book.multiplication.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Event that models the fact that a {@link microservices.book.multiplication.domain.Multiplication}
 * has been solved in the system. Provides some context information about the multiplication.
 */
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final Long multiplicationResultAttemptId;
	private final Long userId;
	private final boolean correct;
	
	
	public MultiplicationSolvedEvent() {
		super();
		this.multiplicationResultAttemptId = 0L;
		this.userId = 0L;
		this.correct = false;
	
	}
	
}