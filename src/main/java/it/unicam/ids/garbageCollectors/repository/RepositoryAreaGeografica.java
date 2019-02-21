package it.unicam.ids.garbageCollectors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.ids.garbageCollectors.entity.AreaGeografica;

@Repository
public interface RepositoryArea extends JpaRepository<AreaGeografica, Integer> {

	public List<AreaGeografica> findByNomeStartingWith(String s);

	public AreaGeografica findByNome(String nomeArea);
}
