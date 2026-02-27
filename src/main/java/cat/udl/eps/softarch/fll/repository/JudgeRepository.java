package cat.udl.eps.softarch.fll.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import cat.udl.eps.softarch.fll.domain.Judge;

@RepositoryRestResource
public interface JudgeRepository extends CrudRepository<Judge, Long>, PagingAndSortingRepository<Judge, Long> {

	List<Judge> findAll();

}
