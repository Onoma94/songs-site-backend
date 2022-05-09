package a.songs_site;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name="guestbook")
@Data
public class GuestBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	private String postcontent;
	private String postauthor;
	@CreationTimestamp
	private Timestamp postdate;
	
	public int getPostId() {
		return postid;
	}

	public String getPostContent() {
		return postcontent;
	}
	public void setPostContent(String postcontent) {
		this.postcontent = postcontent;
	}
	public String getPostAuthor() {
		return postauthor;
	}
	public void setPostAuthor(String postauthor) {
		this.postauthor = postauthor;
	}
	public Timestamp getPostDate() {
		return postdate;
	}
	public void setPostDate(Timestamp postdate) {
		this.postdate = postdate;
	}
	
	public GuestBook(String postcontent, String postauthor, Timestamp postdate) 
	{
		this.postcontent = postcontent;
		this.postauthor = postauthor;
		this.postdate = postdate;
	}
	public GuestBook()
	{
		
	}

}
