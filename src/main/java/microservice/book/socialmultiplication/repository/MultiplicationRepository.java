package microservice.book.socialmultiplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.book.socialmultiplication.domain.Multiplication;

public interface MultiplicationRepository extends JpaRepository<Multiplication, Long>{

}
