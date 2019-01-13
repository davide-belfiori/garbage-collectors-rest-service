package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.AreaGeografica;
import it.unicam.ids.garbageCollectors.entity.PoliticaSmaltimento;
import it.unicam.ids.garbageCollectors.exception.AreaNotFoundException;
import it.unicam.ids.garbageCollectors.service.ServiceArea;

@RestController
public class GestoreAreaGeografica {
	
	@Autowired
	private ServiceArea service;
	
	@GetMapping(value = "/area-geografica/{areaId}")
	public AreaGeografica getAreaById(@PathVariable("areaId") int areaId) throws AreaNotFoundException {
		
		Optional<AreaGeografica> result = service.getAreaById(areaId);
		if(result.isPresent())
			return result.get();
		
		throw new AreaNotFoundException(areaId);		
	}
	
	@GetMapping(value = "/area-geografica/{areaId}/ricerca/{prodId}")
	public List<PoliticaSmaltimento> ricerca(@PathVariable("areaId") int areaId,
										 @PathVariable("prodId") String prodId) 
												 throws AreaNotFoundException {
		
		AreaGeografica area = getAreaById(areaId);
		return area.getListaPolitiche(prodId);
		
		//return service.ricerca(areaId, prodId);
	}
}