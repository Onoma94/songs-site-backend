package a.songs_site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChartDatesRepository extends JpaRepository<ChartDate, Integer>, JpaSpecificationExecutor<ChartDate> 
{
	List<ChartDate> findByChartno(int chartno);
}
