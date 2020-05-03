package r.gabaglia.moviecatalog.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import r.gabaglia.moviecatalog.entities.Movie;
import r.gabaglia.moviecatalog.entities.Protagonist;
import r.gabaglia.moviecatalog.repositories.MovieRepository;
import r.gabaglia.moviecatalog.repositories.ProtagonistRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	ProtagonistRepository protagonistRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		Movie m1 = new Movie("titulo1", sdf.parse("1991"), "Diretor 1");
		Movie m2 = new Movie("titulo2", sdf.parse("1992"), "Diretor 2");
		Movie m3 = new Movie("titulo3", sdf.parse("1993"), "Diretor 3");
		Movie m4 = new Movie("titulo4", sdf.parse("1994"), "Diretor 4");

		Protagonist p1 = new Protagonist("Emma");
		Protagonist p2 = new Protagonist("Daniel");

		movieRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
		protagonistRepository.saveAll(Arrays.asList(p1, p2));

	}

}
