package microservice.book.socialmultiplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class MultiplicationResultAttempt {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private Long id; 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MULTIPLICATION_ID")
	private final Multiplication multiplication;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private final User user;
	
	@Column(name = "RESULT_ATTEMPT")
	private final int resultAttempt;
	
	@Column(name = "IS_CORRECT")
	private final boolean correct;

	public MultiplicationResultAttempt() {
		this.multiplication = null;
		this.user = null;
		this.resultAttempt = -1;
		this.correct = false;
	}

}
