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
	
	@Column(name="artistid")
	@NotNull(message="{NotNull.Song.artistid}")
	private int artistid;
	
	@Column(name="artistname")
	@NotNull(message="{NotNull.Song.artistname}")
	private String artistname;
	
	@Column(name="songtitle")
	@NotNull(message="{NotNull.Song.songtitle}")
	private String songtitle;

	public int getSongId() {
		return songid;
	}

	public void setSongId(int songid) {
		this.songid = songid;
	}
	
	public int getArtistId() {
		return artistid;
	}

	public void setArtistId(int artistid) {
		this.artistid = artistid;
	}

	public void setArtistName(String artistname) {
		this.artistname = artistname;
	}
	
	public String getSongTitle() {
		return songtitle;
	}

	public void setSongTitle(String songtitle) {
		this.songtitle = songtitle;
	}
	
	public Song(int artistid, String songtitle)
	{
		this.artistid = artistid;
		this.songtitle = songtitle;
	}
	
	public Song()
	{

	}

}
