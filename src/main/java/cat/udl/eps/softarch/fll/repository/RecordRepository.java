package cat.udl.eps.softarch.fll.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import cat.udl.eps.softarch.fll.domain.Record;
import cat.udl.eps.softarch.fll.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Records", description = "Repository for managing Record entities")
@RepositoryRestResource
public interface RecordRepository extends CrudRepository<Record, Long>, PagingAndSortingRepository<Record, Long> {
	@Operation(summary = "Find records by owner",
			description = "Returns a list of Records owned by the specified User.")
	List<Record> findByOwner(@Param("user") User owner);
}
