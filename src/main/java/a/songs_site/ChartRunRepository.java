package a.songs_site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChartRunRepository extends JpaRepository<ChartRun, Integer>, JpaSpecificationExecutor<ChartRun>
{
	@Query(value = "SELECT chartid, charts1.chartno AS chartno, chartpos, chartdate "
			+ "FROM charts1 "
			+ "JOIN chart1_dates ON charts1.chartno = chart1_dates.chartno "
			+ "WHERE charts1.songid = :songid "
			+ "ORDER BY chartno", nativeQuery = true)
	List<ChartRun> getChartRun(@Param("songid") int songid);
}
