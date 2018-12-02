package microservices.book.multiplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "USER")
public final class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "ALIAS", unique = true, nullable = false, length = 150)
	private final String alias;

	// Empty constructor for JSON/JPA
	protected User() {
		alias = null;
	}
}
