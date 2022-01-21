package a.songs_site;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="charts1_view")
@Data
public class Chart {

	@Id
	private int chartid;
	
	@Column(name="chartno")
	private int chartno;
	
	@Column(name="chartpos")
	private int chartpos;
	
	@Column(name="artistname")
	private String artistname;
	
	@Column(name="songtitle")
	private String songtitle;
	
	public Chart(int chartno, int chartpos, String artistname, String songtitle)
	{
		this.chartno = chartno;
		this.chartpos = chartpos;
		this.artistname = artistname;
		this.songtitle = songtitle;
	}
	
	public Chart()
	{

	}
}
