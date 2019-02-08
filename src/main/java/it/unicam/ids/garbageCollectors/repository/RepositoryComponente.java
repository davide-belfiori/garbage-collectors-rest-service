package it.unicam.ids.garbageCollectors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.ids.garbageCollectors.entity.Componente;
import it.unicam.ids.garbageCollectors.entity.id.ComponenteId;

public interface RepositoryComponente extends JpaRepository<Componente, ComponenteId> {

}
