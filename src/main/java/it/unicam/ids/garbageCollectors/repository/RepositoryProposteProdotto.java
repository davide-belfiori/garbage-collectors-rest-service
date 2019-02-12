package it.unicam.ids.garbageCollectors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;

public interface RepositoryProposteProdotto extends JpaRepository<PropostaProdotto, PropostaProdottoId> {

	public List<PropostaProdotto> findAllByOrderByCreated();
	
/*	@Query()
	public List<?> raggruppa();*/
	
	@Query(value = "SELECT * FROM contatore_proposte c", nativeQuery = true)
	public int conta();
	
	@Modifying
	@Query(value = "UPDATE contatore_proposte SET count = count + 1", nativeQuery = true)
	public void incrementa();
}
