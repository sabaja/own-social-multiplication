package microservice.book.socialmultiplication.service;

public interface RandomGeneratorService {

    /**
     * @return a randomly-generated factor. It's always a number between 1 and 99.
     */
   public int generateRandomFactor();

}