package microservices.book.multiplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import microservices.book.multiplication.domain.User;

/**
 * This interface allows us to save and retrieve Users
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAlias(final String alias);

}
