package a.songs_site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource()
public interface SongsRepository extends JpaRepository<Songs, Integer>, JpaSpecificationExecutor<Songs>, QuerydslPredicateExecutor<Songs> 
{
	List<Songs> findByTitleContaining(String title);
}