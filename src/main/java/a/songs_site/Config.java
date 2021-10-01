package a.songs_site;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Song.class)
public class Config {
	@Bean
	public Song getSong()
	{
		return new Song(666, "Manfred Mann","Blinded By The Light");
	}
}
