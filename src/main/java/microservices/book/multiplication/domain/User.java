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

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1490401593315076434L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false, unique = true)
	private Long id; 
	
	@Column(name = "ALIAS", unique = true, nullable = false, length = 150)
	private final String alias;

	public User() {
		this("");
	}
}
