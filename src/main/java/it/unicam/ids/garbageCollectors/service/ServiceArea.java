package it.unicam.ids.garbageCollectors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.ids.garbageCollectors.entity.AreaGeografica;
import it.unicam.ids.garbageCollectors.entity.PoliticaSmaltimento;
import it.unicam.ids.garbageCollectors.repository.RepositoryArea;
import it.unicam.ids.garbageCollectors.repository.RepositoryPolitiche;

@Service
public class ServiceArea {

	@Autowired
	private RepositoryArea repo;
	
	@Autowired
	private RepositoryPolitiche pRepo;
	
	public Optional<AreaGeografica> getAreaById(int areaId) {
		return repo.findById(areaId);
	}
	
	public List<PoliticaSmaltimento> ricerca(int areaId, String prodId) {
		return pRepo.findByPolIdProdIdAndPolIdAreaId(prodId, areaId);
	}
}
