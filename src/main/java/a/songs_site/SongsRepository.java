package a.songs_site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource()
public interface SongsRepository extends JpaRepository<Song, Integer>, JpaSpecificationExecutor<Song> 
{
	List<Song> findBySongtitleContaining(String songtitle);
	List<Song> findByArtistid(int artistid);
}