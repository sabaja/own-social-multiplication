package microservices.book.multiplication.multiplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name="MULTIPLICATION")
public final class Multiplication{


	@Id
	@GeneratedValue
	@Column(name = "MULTIPLICATION_ID")
	private Long id;

	@Column(name = "FACTOR_A")
	private final int factorA;

	@Column(name = "FACTOR_B")
	private final int factorB;

	@Column(name = "RESULT")
	private int result;

	public Multiplication() {
		this(0, 0);
	}
}
