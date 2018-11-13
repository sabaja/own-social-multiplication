package microservices.book.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final Long multiplicationResultAttemptId;
	private final Long userId;
	private final boolean correct;
	
}
