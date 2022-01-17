package a.songs_site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource()
public interface ArtistsRepository extends JpaRepository<Artist, Integer>, JpaSpecificationExecutor<Artist> 
{
	List<Artist> findByArtistnameContaining(String artistname);
}