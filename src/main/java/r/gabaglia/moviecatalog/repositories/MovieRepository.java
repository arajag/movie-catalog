package r.gabaglia.moviecatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.gabaglia.moviecatalog.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findByTitle(String title);
}
