package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.AreaGeografica;
import it.unicam.ids.garbageCollectors.entity.PoliticaSmaltimento;
import it.unicam.ids.garbageCollectors.exception.AreaNotFoundException;
import it.unicam.ids.garbageCollectors.exception.BarcodeFormatException;
import it.unicam.ids.garbageCollectors.service.ServiceArea;

@RestController
@RequestMapping(value = "/api/area-geografica")
public class GestoreAreaGeografica {
	
	@Autowired
	private ServiceArea service;
	
	/* restituisce l'area geografica con il dato id, se esiste */
	
	@GetMapping(value = "/{areaId}")
	public AreaGeografica getAreaById(@PathVariable("areaId") int areaId) throws AreaNotFoundException, NumberFormatException {
		return service.getAreaById(areaId);		
	}
	
	/* restituisce l'area il quale nome inizia con la stringa specificata */
	@GetMapping(value = "/like/{name}")
	public List<AreaGeografica> getAreaLike(@PathVariable("name") String name) throws AreaNotFoundException {		
		List<AreaGeografica> result = service.getAreaLike(name);
		if(result == null)
			throw new AreaNotFoundException(name);
		return result;
	}
	
	/* restituisce la lista delle aree geografiche esistenti */
	@GetMapping()
	public List<AreaGeografica> getListaAree (){
		return service.getListaAree();
	}
	
	/* restiuisce la lista delle politiche di smaltimento di un prodotto
	 * nell'area desiderata
	 */
	
	@GetMapping(value = "/{nomeArea}/ricerca/{prodId}")
	public List<PoliticaSmaltimento> ricerca(@PathVariable("nomeArea") String nomeArea,
										 @PathVariable("prodId") String prodId) 
												 throws AreaNotFoundException {
		
		AreaGeografica area = service.findAreaByNome(nomeArea);
		if(area == null)
			throw new AreaNotFoundException(nomeArea);
		
		return area.getListaPolitiche(prodId);
	}
}