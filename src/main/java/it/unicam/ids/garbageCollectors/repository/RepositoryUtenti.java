package it.unicam.ids.garbageCollectors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.ids.garbageCollectors.entity.AppUser;

public interface RepositoryUtenti extends JpaRepository<AppUser, Integer> {

	AppUser findByUsername(String nomeUtente);

}
