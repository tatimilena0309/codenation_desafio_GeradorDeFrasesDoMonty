package challenge;

import challenge.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface QuoteRepository extends CrudRepository<Quote, Integer> {
    @Query(value = "select id,actor,detail from scripts ORDER BY random() limit 1", nativeQuery = true)
    Quote getQuote();

    @Query(value = "select id,actor,detail from scripts where actor like :actor ORDER BY random() limit 1", nativeQuery = true)
    Quote getQuoteByActor(@Param("actor") String actor);

}

