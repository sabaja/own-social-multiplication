package microservices.book.multiplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import microservices.book.multiplication.domain.Multiplication;

/**
 * This interface allows us to save and retrieve Multiplications
 */
public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {
}
