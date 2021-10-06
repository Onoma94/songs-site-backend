package a.songs_site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/")
public class SongsController 
{
	@Autowired
	SongsService songsService;
	
	@GetMapping("/songs/")
	public ResponseEntity<?> listSongs()
	{
		log.info("SongsController:  list songs");
		List<Songs> resource = songsService.getSongs();
		return ResponseEntity.ok(resource);
	}
	
	@PostMapping("/add_songs/")
	public ResponseEntity<?> saveSong(@RequestBody Songs song)
	{
		log.info("SongsController:  list songs");
		Songs resource = songsService.saveSong(song);
		return ResponseEntity.ok(resource);
	}
}
