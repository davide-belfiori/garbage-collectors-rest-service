package it.unicam.ids.garbageCollectors.gestori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.repository.RepositoryUtenti;

@RestController
@RequestMapping("/api/utenti")
public class GestoreUtenti {

	@Autowired
	private RepositoryUtenti repo;
	
	@PreAuthorize(value = "hasAuthority('AUTORITA')")
	@GetMapping("/count")
	public long getUsersCount() {
		return repo.count();
	}
}
