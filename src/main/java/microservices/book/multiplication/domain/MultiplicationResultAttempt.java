package microservices.book.multiplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public final class MultiplicationResultAttempt {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id; 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private final User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MULTIPLICATION_ID")
	private final Multiplication multiplication;
	
	@Column(name = "RESULT_ATTEMPT")
	private final int resultAttempt;
	
	@Column(name = "IS_CORRECT")
	private final boolean correct;

	MultiplicationResultAttempt() {
		this.multiplication = null;
		this.user = null;
		this.resultAttempt = -1;
		this.correct = false;
	}
}
