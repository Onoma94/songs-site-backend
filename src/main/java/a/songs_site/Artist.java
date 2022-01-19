package a.songs_site;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="artists1")
@Data
public class Artist 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="artistid")
	private int artistid;
	
	@Column(name="artistname")
	@NotNull(message="{NotNull.Artist.artistname}")
	private String artistname;

	public int getArtistId() {
		return artistid;
	}

	public void setArtistId(int artistid) {
		this.artistid = artistid;
	}
	
	public String getArtistName() {
		return artistname;
	}

	public void setArtistName(String artistname) {
		this.artistname = artistname;
	}
	
	public Artist(String artistname)
	{
		this.artistname = artistname;
	}
	public Artist()
	{

	}
}