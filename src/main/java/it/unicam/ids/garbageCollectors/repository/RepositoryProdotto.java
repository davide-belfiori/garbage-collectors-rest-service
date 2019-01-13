package it.unicam.ids.garbageCollectors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.ids.garbageCollectors.entity.Prodotto;

public interface RepositoryProdotto extends JpaRepository<Prodotto, String> {
	
}
