package cat.udl.eps.softarch.fll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import cat.udl.eps.softarch.fll.domain.Match;

@Repository
@RepositoryRestResource
public interface MatchRepository extends CrudRepository<Match, Long>, PagingAndSortingRepository<Match, Long> {
}
