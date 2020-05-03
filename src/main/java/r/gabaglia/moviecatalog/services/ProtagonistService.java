package r.gabaglia.moviecatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r.gabaglia.moviecatalog.entities.Protagonist;
import r.gabaglia.moviecatalog.repositories.ProtagonistRepository;

@Service
public class ProtagonistService {

	@Autowired
	private ProtagonistRepository repository;

	public List<Protagonist> findAll() {
		return repository.findAll();
	}

	/*
	 * TODO: Create and define a exception in case of don't have the ID in database.
	 */
	public Protagonist findById(int id) {
		Optional<Protagonist> movie = repository.findById(id);
		return movie.get();
	}

	public Protagonist findByName(String name) {
		Protagonist protagonist = findAll().stream().filter(x -> x.getName().equals(name)).findFirst().get();
		return findById(protagonist.getId());
	}

	public Protagonist insert(Protagonist protagonist) {
		return repository.save(protagonist);
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
	public Protagonist update(int id, Protagonist protagonist) {
		Protagonist protagonistToUpdate = repository.getOne(id);
		updateProtagonist(protagonistToUpdate, protagonist);
		return repository.save(protagonistToUpdate);
	}

	private void updateProtagonist(Protagonist protagonistToUpdate, Protagonist protagonist) {
		protagonistToUpdate.setName(protagonist.getName());
	}

}
