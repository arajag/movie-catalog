package r.gabaglia.moviecatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import r.gabaglia.moviecatalog.entities.Movie;
import r.gabaglia.moviecatalog.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll(){
		List<Movie> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Movie> findById(@PathVariable int id) {
		Movie movie = service.findById(id);
		return ResponseEntity.ok().body(movie);
	}
	
	@GetMapping(value = "/title")
	public ResponseEntity<Movie> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
		Movie movie = service.findByTitle(title);
		return ResponseEntity.ok().body(movie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> insert(@RequestBody Movie movie) {
		service.insert(movie);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();
		return ResponseEntity.created(uri).body(movie);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Movie> update(@PathVariable int id, @RequestBody Movie movie) {
		Movie movieToUpdate = service.update(id, movie);
		return ResponseEntity.ok().body(movieToUpdate);
	}


}
