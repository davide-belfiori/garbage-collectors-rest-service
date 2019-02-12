package it.unicam.ids.garbageCollectors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;

public interface RepositoryProposteProdotto extends JpaRepository<PropostaProdotto, PropostaProdottoId> {

	public List<PropostaProdotto> findAllByOrderByCreated();
	
}
