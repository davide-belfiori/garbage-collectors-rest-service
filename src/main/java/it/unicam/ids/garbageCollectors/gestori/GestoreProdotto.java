package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.Componente;
import it.unicam.ids.garbageCollectors.entity.Prodotto;
import it.unicam.ids.garbageCollectors.exception.BindingException;
import it.unicam.ids.garbageCollectors.exception.DuplicatedProductException;
import it.unicam.ids.garbageCollectors.exception.ProductNotFoundException;
import it.unicam.ids.garbageCollectors.exception.UnknowException;
import it.unicam.ids.garbageCollectors.service.ServiceProdotto;
import it.unicam.ids.garbageCollectors.service.ServiceProposte;

/* controller dei Prodotti */

@RestController
@RequestMapping("/api/products")
public class GestoreProdotto {

	@Autowired
	private ServiceProdotto serviceProdotto;
	
	@Autowired
	private ServiceProposte serviceProposte;
	
	/* restituisce la lista dei componenti di un certo prodotto */
	
	@PreAuthorize(value = "hasAuthority('AUTORITA')")
	@GetMapping("/{prodId}/components")
	public List<Componente> getlistaComponenti(@PathVariable("prodId") String prodId) throws ProductNotFoundException {
		List<Componente> lista = serviceProdotto.getComponenti(prodId);
		if(lista == null)
			throw new ProductNotFoundException(prodId);
		return lista;
	}

	/* restituisce il prodotto con un certo ID */
	@GetMapping("/{prodId}")
	public Prodotto getProdottoById(@PathVariable("prodId") String prodId) throws ProductNotFoundException {	
		return serviceProdotto.getProdotto(prodId);
	}
	
	
	@GetMapping("/esiste/{prodId}")
	public boolean esisteProdotto(@PathVariable("prodId") String prodId) {
		return serviceProdotto.esisteProdotto(prodId);
	}
	
	/* restituisce la lista di tutti i prodotti */
	
	@GetMapping
	public List<Prodotto> getProdotti() throws ProductNotFoundException {
		return serviceProdotto.findAll();
	}
	
	/* salva un nuovo prodotto */
	
	@PreAuthorize(value = "hasAuthority('AUTORITA')")
	@PostMapping
	public Prodotto addProduct(@RequestParam(name = "nomeProdotto") String nomeProdotto,
			  				   @RequestParam(name = "prodId") String prodId) 
			throws BindingException, DuplicatedProductException, UnknowException {
		
		if(nomeProdotto == null || prodId == null) {
			throw new BindingException();
		}
		
		/* if(checkProdId(prodId)){
		 * 	    throw new BarcodeFormatException(prodId);
		 * }
		 */
		
		Prodotto newProd = serviceProdotto.salvaProdotto(nomeProdotto, prodId);
		if(newProd != null) {
			serviceProposte.scartaTutteByProdId(prodId);
			return newProd;
		} else throw new UnknowException();
	}
	
	@PreAuthorize(value = "hasAuthority('AUTORITA')")
	@GetMapping("/count")
	public long contaProdotti() {
		return serviceProdotto.contaProdotti();
	}
	
	private boolean checkProdId (String prodId) throws NumberFormatException {
		
		if(prodId.length() == 12)
			prodId = "0" + prodId;
		
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