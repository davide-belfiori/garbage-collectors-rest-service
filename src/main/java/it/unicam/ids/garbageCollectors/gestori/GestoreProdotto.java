package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.Componente;
import it.unicam.ids.garbageCollectors.entity.Prodotto;
import it.unicam.ids.garbageCollectors.exception.BindingExcetion;
import it.unicam.ids.garbageCollectors.exception.DuplicatedProductException;
import it.unicam.ids.garbageCollectors.exception.ProductNotFoundException;
import it.unicam.ids.garbageCollectors.service.ServiceProdotto;

/* controller dei Prodotti */

@RestController
@RequestMapping("/products")
public class GestoreProdotto {

	@Autowired
	private ServiceProdotto service;
	
	/* restituisce la lista dei componenti di un certo prodotto */
	
	@PreAuthorize(value = "hasAuthority('AUTORITA')")
	@GetMapping("/{prodId}/components")
	public List<Componente> getlistaComponenti(@PathVariable("prodId") String prodId) throws ProductNotFoundException {
		List<Componente> lista = service.getComponenti(prodId);
		if(lista == null)
			throw new ProductNotFoundException(prodId);
		return lista;
	}

	/* restituisce il prodotto con un certo ID */
	@GetMapping("/{prodId}")
	public Prodotto getProdottoById(@PathVariable("prodId") String prodId) throws ProductNotFoundException {	
		return service.getProdotto(prodId);
	}
	
	
	@GetMapping("/esiste/{prodId}")
	public boolean esisteProdotto(@PathVariable("prodId") String prodId) {		
		return service.esisteProdotto(prodId);
	}
	
	/* restituisce la lista di tutti i prodotti */
	
	@GetMapping
	public List<Prodotto> getProdotti() throws ProductNotFoundException {
		return service.findAll();
	}
	
	/* salva un nuovo prodotto */
	
	@PreAuthorize(value = "hasAuthority('AUTORITA')")
	@PostMapping
	public Prodotto addProduct(@Valid @RequestBody Prodotto product, BindingResult bindingResult) 
			throws BindingExcetion, DuplicatedProductException {
		
		if(bindingResult.hasErrors()) {
			throw new BindingExcetion();
		}	
		
		return service.salvaProdotto(product);
	}
}