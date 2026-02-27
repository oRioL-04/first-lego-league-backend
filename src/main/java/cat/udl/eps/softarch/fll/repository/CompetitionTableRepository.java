package cat.udl.eps.softarch.fll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import cat.udl.eps.softarch.fll.domain.CompetitionTable;

@Repository
@RepositoryRestResource
public interface CompetitionTableRepository extends CrudRepository<CompetitionTable, String>, PagingAndSortingRepository<CompetitionTable, String> {

}
