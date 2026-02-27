package cat.udl.eps.softarch.fll.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import cat.udl.eps.softarch.fll.domain.Edition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Editions", description = "Repository for managing Edition entities")
@RepositoryRestResource
public interface EditionRepository extends CrudRepository<Edition, Long>, PagingAndSortingRepository<Edition, Long> {

	@Operation(summary = "Search editions by year",
			description = "Returns a list of Editions for the specified year.")
	List<Edition> findByYear(@Param("year") Integer year);

	@Operation(summary = "Search editions by venue name",
			description = "Returns a list of Editions for the specified venue.")
	List<Edition> findByVenueName(@Param("venueName") String venueName);

}
