package microservice.book.socialmultiplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationResultAttempRepository extends CrudRepository<MultiplicationResultAttempt, Long> {

	/**
	 * 
	 * @param userAlias
	 * @return The 5 last multiplication result attempt by user alias
	 */
	public List<MultiplicationResultAttempt> findTop5ByUserAliasdOrderByUserIdDesc(String alias);

}
