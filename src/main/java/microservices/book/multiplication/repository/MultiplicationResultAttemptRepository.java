package microservices.book.multiplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import microservices.book.multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationResultAttemptRepository extends JpaRepository<MultiplicationResultAttempt, Long> {

	/**
	 * 
	 * @param userAlias
	 * @return The 5 last multiplication result attempt by user alias
	 */
	public List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String alias);

}
