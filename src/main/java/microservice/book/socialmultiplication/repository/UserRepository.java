package microservice.book.socialmultiplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.book.socialmultiplication.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByAlias(final String alias);
	

}
