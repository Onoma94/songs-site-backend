package a.songs_site;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class SongsService 
{
	private SongsRepository songsRepository;
	
	public SongsService(SongsRepository songsRepository)
	{
        this.songsRepository = songsRepository;
    }
	
	public List<Songs> getSongs()
	{
        return songsRepository.findAll();
    }
	
	public Songs saveSong(Songs songs)
	{
    	songs.setId(new Random().nextInt());
    	return songsRepository.save(songs);
    }

}
