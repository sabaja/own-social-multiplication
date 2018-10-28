package microservice.book.socialmultiplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationResultAttempRepository extends JpaRepository<MultiplicationResultAttempt, Long> {

	/**
	 * 
	 * @param userAlias
	 * @return The 5 last multiplication result attempt by user alias
	 */
	public List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByUserIdDesc(String alias);

}
