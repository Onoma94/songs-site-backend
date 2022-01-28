package a.songs_site;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ChartRun {

	@Id
	@Column
	private int chartid;
	
	public int getChartid() {
		return chartid;
	}
	public void setChartid(int chartid) {
		this.chartid = chartid;
	}

	public int getChartno() {
		return chartno;
	}
	
	public void setChartno(int chartno) {
		this.chartno = chartno;
	}

	public int getChartpos() {
		return chartpos;
	}

	public void setChartpos(int chartpos) {
		this.chartpos = chartpos;
	}

	@Column(name="chartno")
	private int chartno;
	
	@Column(name="chartpos")
	private int chartpos;
	
	@Temporal(TemporalType.DATE)
	@Column(name="chartdate")
	private Date chartdate;
	
	public Date getChartdate() {
		return chartdate;
	}

	public void setChartdate(Date chartdate) {
		this.chartdate = chartdate;
	}
	
	public ChartRun()
	{
		
	}
	
	public ChartRun(int chartid, int chartno, int chartpos, Date chartdate)
	{
		this.chartno = chartno;
		this.chartpos = chartpos;
		this.chartdate = chartdate;
	}
	
}