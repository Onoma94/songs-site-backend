package a.songs_site;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Songs 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SongID")
	private int id;
	
	@Column(name="ArtistName")
	@NotNull(message="{NotNull.Song.artist}")
	private String artist;
	
	@Column(name="Title")
	@NotNull(message="{NotNull.Song.title}")
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
