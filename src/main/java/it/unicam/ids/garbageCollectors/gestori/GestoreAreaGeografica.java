package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;
import java.util.Optional;

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
@RequestMapping(value = "/area-geografica")
public class GestoreAreaGeografica {
	
	@Autowired
	private ServiceArea service;
	
	/* restituisce l'area geografica con il dato id, se esiste */
	
	@GetMapping(value = "/{areaId}")
	public AreaGeografica getAreaById(@PathVariable("areaId") int areaId) throws AreaNotFoundException, NumberFormatException {
		
		Optional<AreaGeografica> result = service.getAreaById(areaId);
		if(result.isPresent())
			return result.get();
		
		throw new AreaNotFoundException(areaId);		
	}
	
	/* restituisce l'area il quale nome inizia con la string specificata */
	
	@GetMapping(value = "/like/{name}")
	public AreaGeografica getAreaLike(@PathVariable("name") String name) throws AreaNotFoundException {		
		AreaGeografica result = service.getAreaLike(name);
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
												 throws AreaNotFoundException, BarcodeFormatException {
		
/*		if(!checkProdId(prodId)) {
			throw new BarcodeFormatException(prodId);
		}*/
		
		AreaGeografica area = service.findAreaByNome(nomeArea);
		if(area == null)
			throw new AreaNotFoundException(nomeArea);
		
		return area.getListaPolitiche(prodId);
	}

	private boolean checkProdId (String prodId) throws NumberFormatException {
		
		int somma = 0;
		for (int i = 0; i < 12; i++) {
			try {
				if((i + 1) % 2 == 0)
					somma = somma + (Integer.parseInt((String) prodId.subSequence(i, i+1)) * 3);
				else
					somma = somma + Integer.parseInt((String) prodId.subSequence(i, i+1));
			} catch (NumberFormatException e) {
				return false;
			}
		}		
		if((somma + Integer.parseInt((String) prodId.subSequence(12, 13))) % 10 == 0) {
			return true;
		} else 
			return false;
	}
}