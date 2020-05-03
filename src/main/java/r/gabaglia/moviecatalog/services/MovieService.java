package r.gabaglia.moviecatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r.gabaglia.moviecatalog.entities.Movie;
import r.gabaglia.moviecatalog.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public List<Movie> findAll(){
		return repository.findAll();
	}
	
	/*
	 * TODO: Create and define a exception in case of don't have the ID in database.
	 */
	public Movie findById(int id) {
		Optional<Movie> movie = repository.findById(id);
		return movie.get();
	}
	
	public Movie findByTitle(String title) {
		Movie movie = repository.findByTitle(title);
		return movie;
	}
	
	public Movie insert(Movie movie) {
		return repository.save(movie);
	}
	
	/*
	 * TODO: Test and add personalized exceptions.
	 */
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	/*
	 * TODO: Personalize an exception in case of it dosn't find the movie to update.
	 */
	public Movie update(int id, Movie movie) {
		Movie movieToUpdate = repository.getOne(id);
		updateMovie(movieToUpdate, movie);
		return repository.save(movieToUpdate);
	}

	private void updateMovie(Movie movieToUpdate, Movie movie) {
		movieToUpdate.setTitle(movie.getTitle());
		movieToUpdate.setDirector(movie.getDirector());
		movieToUpdate.setYear(movie.getYear());	
	}

}
