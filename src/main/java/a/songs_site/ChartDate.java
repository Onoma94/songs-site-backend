package a.songs_site;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="chart1_dates")
@Data
public class ChartDate {

	@Id
	@Column(name="chartno")
	private int chartno;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name="chartdate")
	private Date chartdate;
	
	public ChartDate(int chartno, Date chartDate)
	{
		this.chartno = chartno;
		this.chartdate = chartDate;
	}
	
	public ChartDate()
	{

	}
}
