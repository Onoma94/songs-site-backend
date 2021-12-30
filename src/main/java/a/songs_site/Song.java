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
@Table(name="songs1_view")
@Data
public class Song 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="songid")
	private int songid;
	
	@Column(name="artistname")
	@NotNull(message="{NotNull.Song.artistName}")
	private String artistname;
	
	@Column(name="title")
	@NotNull(message="{NotNull.Song.title}")
	private String title;

	public int getSongId() {
		return songid;
	}

	public void setSongId(int songid) {
		this.songid = songid;
	}
	
	public String getArtistName() {
		return artistname;
	}

	public void setArtistName(String artistname) {
		this.artistname = artistname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Song(String artistname, String title)
	{
		this.artistname = artistname;
		this.title = title;
	}
	
	public Song()
	{

	}
}
