package r.gabaglia.moviecatalog.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import r.gabaglia.moviecatalog.entities.Movie;
import r.gabaglia.moviecatalog.repositories.MovieRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		Movie m1 = new Movie("Título 1", sdf.parse("1991"), "Diretor 1");
		Movie m2 = new Movie("Título 2", sdf.parse("1992"), "Diretor 2");
		Movie m3 = new Movie("Título 3", sdf.parse("1993"), "Diretor 3");
		Movie m4 = new Movie("Título 4", sdf.parse("1994"), "Diretor 4");
		
		movieRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
			
	}

}
