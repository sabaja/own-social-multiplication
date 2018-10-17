package microservice.book.socialmultiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Multiplication {

	private final int factorA;
	private final int factorB;
	private int result;

	public Multiplication() {
		this(0, 0);
		this.result = 0;
	}

	public int getResult() {
		this.result = this.factorA * this.factorB;
		return result;
	}
}
