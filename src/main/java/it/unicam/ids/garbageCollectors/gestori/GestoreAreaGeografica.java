package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.AreaGeografica;
import it.unicam.ids.garbageCollectors.entity.PoliticaSmaltimento;
import it.unicam.ids.garbageCollectors.exception.AreaNotFoundException;
import it.unicam.ids.garbageCollectors.service.ServiceArea;

@RestController
@CrossOrigin(origins = "*")
public class GestoreAreaGeografica {
	
	@Autowired
	private ServiceArea service;
	
	/* restituisce l'area geografica con il dato id, se esiste */
	
	@GetMapping(value = "/area-geografica/{areaId}")
	public AreaGeografica getAreaById(@PathVariable("areaId") int areaId) throws AreaNotFoundException {
		
		Optional<AreaGeografica> result = service.getAreaById(areaId);
		if(result.isPresent())
			return result.get();
		
		throw new AreaNotFoundException(areaId);		
	}
	
	/* restituisce l'area il quale nome inizia con la string specificata */
	
	@GetMapping(value = "/area-geografica/like/{name}")
	public AreaGeografica getAreaLike(@PathVariable("name") String name) throws AreaNotFoundException {		
		AreaGeografica result = service.getAreaLike(name);
		if(result == null)
			throw new AreaNotFoundException(name);
		return result;
	}
	
	/* restituisce la lista delle aree geografiche esistenti */
	
	@GetMapping(value = "/area-geografica")
	public List<AreaGeografica> getListaAree (){
		return service.getListaAree();
	}
	
	/* restiuisce la lista delle politiche di smaltimento di un prodotto
	 * nell'area desiderata
	 */
	
	@GetMapping(value = "/area-geografica/{nomeArea}/ricerca/{prodId}")
	public List<PoliticaSmaltimento> ricerca(@PathVariable("nomeArea") String nomeArea,
										 @PathVariable("prodId") String prodId) 
												 throws AreaNotFoundException {
		
		System.out.println("ricerca");
		
		AreaGeografica area = service.findAreaByNome(nomeArea);
		if(area == null)
			throw new AreaNotFoundException(nomeArea);
		
		return area.getListaPolitiche(prodId);
		
		//return service.ricerca(areaId, prodId);
	}
}