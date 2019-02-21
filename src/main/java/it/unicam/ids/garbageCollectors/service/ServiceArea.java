package it.unicam.ids.garbageCollectors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.ids.garbageCollectors.entity.AreaGeografica;
import it.unicam.ids.garbageCollectors.exception.AreaNotFoundException;
import it.unicam.ids.garbageCollectors.repository.RepositoryAreaGeografica;

@Service
public class ServiceArea {

	@Autowired
	private RepositoryAreaGeografica repositoryArea;
		
	public AreaGeografica getAreaById(int areaId) throws AreaNotFoundException {
		Optional<AreaGeografica> result = repositoryArea.findById(areaId);
		if(result.isPresent())
			return result.get();
		throw new AreaNotFoundException(areaId);
	}
		
	public List<AreaGeografica> getListaAree() {
		return repositoryArea.findAll();
	}

	public List<AreaGeografica> getAreaLike(String name) {
		return repositoryArea.findByNomeStartingWith(name.toUpperCase());
	}

	public AreaGeografica findAreaByNome(String nomeArea) {
		return repositoryArea.findByNome(nomeArea.toUpperCase());
	}
}
