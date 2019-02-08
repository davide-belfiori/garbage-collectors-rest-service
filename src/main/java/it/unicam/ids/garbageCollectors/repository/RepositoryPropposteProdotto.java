package it.unicam.ids.garbageCollectors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;

public interface RepositoryPropposteProdotto extends JpaRepository<PropostaProdotto, PropostaProdottoId> {

}
