package a.songs_site;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	@Autowired
	ChartsRepository chartsRepository;
	
	@Autowired
	ChartDatesRepository chartDatesRepository;
	
	@Autowired
	ChartRunRepository chartRunRepository;
	
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
	
	@GetMapping("/charts/{chartno}")
	public ResponseEntity<List<Chart>> getChartByChartNo(@PathVariable("chartno") int chartno)
	{
		log.info("SongsController:  list songs by chart");
		try
		{
			List<Chart> charts = new ArrayList<Chart>();
			if (chartno == 0)
			{
				chartsRepository.findAll().forEach(charts::add);
			}
			else
			{
				chartsRepository.findByChartno(chartno).forEach(charts::add);
			}
			if (charts.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(charts, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/songcharts/{songid}")
	public ResponseEntity<List<Chart>> getChartsBySongId(@PathVariable("songid") int songid)
	{
		log.info("ChartsController:  list charts by songid");
		try
		{
			List<Chart> charts = new ArrayList<Chart>();
			if (songid == 0)
			{
				chartsRepository.findAll().forEach(charts::add);
			}
			else
			{
				chartsRepository.findBySongid(songid).forEach(charts::add);
			}
			if (charts.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(charts, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/chartrun/{songid}")
	public ResponseEntity<List<ChartRun>> getChartRun(@PathVariable("songid") int songid)
	{
		log.info("ChartRunController:  list charts by songid");
		try {
			List<ChartRun> chartRun = new ArrayList<ChartRun>();
			if (songid == 0)
			{
				chartRunRepository.findAll().forEach(chartRun::add);
			}
			else
			{
				chartRunRepository.getChartRun(songid).forEach(chartRun::add);
			}
			if (chartRun.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(chartRun, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/chartdates")
	public ResponseEntity<Map<Integer, Date>> listChartDates()
	{
		log.info("SongsController:  list chart dates");
		try
		{
			Map<Integer, Date> chartDates = new HashMap<Integer, Date>();
			chartDatesRepository.findAll().forEach((ChartDate chartDate) ->
			{
				chartDates.put(chartDate.getChartNo(), chartDate.getChartDate());
			});
			return new ResponseEntity<>(chartDates, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/chartdates/{id}")
	public ResponseEntity<ChartDate> getChartDate(@PathVariable("id") int id)
	{
		List<ChartDate> chartDate = chartDatesRepository.findByChartno(id);
		if (chartDate != null)
		{
			return new ResponseEntity<>(chartDate.get(0), HttpStatus.OK);
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
