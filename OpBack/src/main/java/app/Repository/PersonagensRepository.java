package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Personagens;

public interface PersonagensRepository extends JpaRepository<Personagens, Long>{
	List<Personagens> findByTripId(Long tripId); //Checar se é trip ou tripulacao
}
