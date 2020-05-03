package r.gabaglia.moviecatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.gabaglia.moviecatalog.entities.Protagonist;

@Repository
public interface ProtagonistRepository extends JpaRepository<Protagonist, Integer> {

}
