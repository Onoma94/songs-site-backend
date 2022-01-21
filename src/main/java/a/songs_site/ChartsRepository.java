package a.songs_site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ChartsRepository extends JpaRepository<Chart, Integer>, JpaSpecificationExecutor<Chart> 
{
	List<Chart> findByChartno(int chartno);
}