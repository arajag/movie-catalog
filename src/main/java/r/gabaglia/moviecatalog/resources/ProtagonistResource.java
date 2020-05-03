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

import r.gabaglia.moviecatalog.entities.Protagonist;
import r.gabaglia.moviecatalog.services.ProtagonistService;

@RestController
@RequestMapping(value = "/protagonists")
public class ProtagonistResource {

	@Autowired
	private ProtagonistService service;

	@GetMapping
	public ResponseEntity<List<Protagonist>> findAll() {
		List<Protagonist> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Protagonist> findById(@PathVariable int id) {
		Protagonist protagonist = service.findById(id);
		return ResponseEntity.ok().body(protagonist);
	}

	@GetMapping(value = "/name")
	public ResponseEntity<Protagonist> findByName(@RequestParam(value = "name", defaultValue = "") String name) {
		Protagonist protagonist = service.findByName(name);
		return ResponseEntity.ok().body(protagonist);
	}

	@PostMapping
	public ResponseEntity<Protagonist> insert(@RequestBody Protagonist protagonist) {
		service.insert(protagonist);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(protagonist.getId()).toUri();
		return ResponseEntity.created(uri).body(protagonist);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Protagonist> update(@PathVariable int id, @RequestBody Protagonist protagonist) {
		Protagonist protagonistToUpdate = service.update(id, protagonist);
		return ResponseEntity.ok().body(protagonistToUpdate);
	}

}
