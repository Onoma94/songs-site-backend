package a.songs_site;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class SongsController 
{
	@Autowired
	SongsRepository songsRepository;
	
	@Autowired
	ArtistsRepository artistsRepository;
	
	@GetMapping("/songs")
	public ResponseEntity<List<Song>> listSongs(@RequestParam(required = false) String songtitle)
	{
		log.info("SongsController:  list songs");
		try
		{
			List<Song> songs = new ArrayList<Song>();
			if (songtitle == null)
			{
				songsRepository.findAll().forEach(songs::add);
			}
			else
			{
				songsRepository.findBySongtitleContaining(songtitle).forEach(songs::add);
			}
			if (songs.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/songs/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable("id") int id)
	{
		Optional<Song> songData = songsRepository.findById(id);
		if (songData.isPresent())
		{
			return new ResponseEntity<>(songData.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/artists")
	public ResponseEntity<List<Artist>> listArtists(@RequestParam(required = false) String artistname)
	{
		log.info("ArtistsController:  list artists");
		try
		{
			List<Artist> artists = new ArrayList<Artist>();
			if (artistname == null)
			{
				artistsRepository.findAll().forEach(artists::add);
			}
			else
			{
				artistsRepository.findByArtistnameContaining(artistname).forEach(artists::add);
			}
			if (artists.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(artists, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("songsbyartist/{artistid}")
	public ResponseEntity<List<Song>> getSongByArtistId(@PathVariable("artistid") int artistid)
	{
		log.info("SongsController:  list songs by artistid");
		try
		{
			List<Song> songs = new ArrayList<Song>();
			if (artistid == 0)
			{
				songsRepository.findAll().forEach(songs::add);
			}
			else
			{
				songsRepository.findByArtistid(artistid).forEach(songs::add);
			}
			if (songs.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/artists/{id}")
	public ResponseEntity<Artist> getArtistById(@PathVariable("id") int id)
	{
		Optional<Artist> artistData = artistsRepository.findById(id);
		if (artistData.isPresent())
		{
			return new ResponseEntity<>(artistData.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/add_songs")
	public ResponseEntity<?> addSong(@RequestBody Song song)
	{
		try 
		{
			Song newSong = songsRepository.save(new Song(song.getArtistId(), song.getSongTitle()));
			return new ResponseEntity<>(newSong, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
