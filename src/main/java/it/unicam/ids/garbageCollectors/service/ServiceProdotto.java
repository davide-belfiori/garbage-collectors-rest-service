package it.unicam.ids.garbageCollectors.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.ids.garbageCollectors.entity.Componente;
import it.unicam.ids.garbageCollectors.entity.Prodotto;
import it.unicam.ids.garbageCollectors.exception.DuplicatedProductException;
import it.unicam.ids.garbageCollectors.exception.ProductNotFoundException;
import it.unicam.ids.garbageCollectors.repository.RepositoryProdotto;

@Service
public class ServiceProdotto {

	@Autowired
	private RepositoryProdotto repo;

	public List<Componente> getComponenti(String prodId) throws ProductNotFoundException {
		Prodotto prod = getProdotto(prodId);
		if(prod != null) {
			return prod.getComponenti();
		} else return null;
	}

	public Prodotto getProdotto(String prodId) throws ProductNotFoundException {
		Optional<Prodotto> result = repo.findById(prodId);
		if(result.isPresent())
			return result.get();
		throw new ProductNotFoundException(prodId);
	}

	public Componente getComponenteByNome(String idProdotto, String nomeComponente) throws ProductNotFoundException {
		Prodotto prod = getProdotto(idProdotto);
		for (Componente comp : prod.getComponenti()) {
			if(comp.getNomeComponente().equals(nomeComponente))
				return comp;
		} return null;
	}

	public List<Prodotto> findAll() {
		return repo.findAll();
	}

	public Prodotto salvaProdotto(@Valid Prodotto prodotto) throws DuplicatedProductException {
		if(repo.existsById(prodotto.getProdId()))
			throw new DuplicatedProductException(prodotto.getProdId());
		
		return repo.save(prodotto);
	}

	public boolean esisteProdotto(String prodId) {
		return repo.existsById(prodId);
	}
}
