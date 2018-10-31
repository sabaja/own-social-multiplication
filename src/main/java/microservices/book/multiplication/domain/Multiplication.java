package microservices.book.multiplication.domain;

import java.io.Serializable;

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
public final class Multiplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6745854840753509812L;

	@Id
	@GeneratedValue
	@Column(name = "MULTIPLICATION_ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "FACTOR_A")
	private final int factorA;

	@Column(name = "FACTOR_B")
	private final int factorB;

	@Column(name = "RESULT")
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
