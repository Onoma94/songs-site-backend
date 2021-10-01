package a.songs_site;

import org.springframework.stereotype.Component;


@Component
public class Song 
{
	private int id;
	private String artist;
	private String title;
	
	public Song(int id, String artist, String title) {
		super();
		this.id = id;
		this.artist = artist;
		this.title = title;
	}

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
	
	public void display() {
		System.out.println(id + " - " + artist + " - " + title);
	}

}