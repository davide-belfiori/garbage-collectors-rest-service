package it.unicam.ids.garbageCollectors.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.ids.garbageCollectors.entity.Componente;
import it.unicam.ids.garbageCollectors.entity.Prodotto;
import it.unicam.ids.garbageCollectors.entity.id.ComponenteId;
import it.unicam.ids.garbageCollectors.exception.DuplicatedProductException;
import it.unicam.ids.garbageCollectors.exception.ProductNotFoundException;
import it.unicam.ids.garbageCollectors.repository.RepositoryComponente;
import it.unicam.ids.garbageCollectors.repository.RepositoryProdotto;

@Service
public class ServiceProdotto {

	@Autowired
	private RepositoryProdotto repositoryProdotto;
	
	@Autowired
	private RepositoryComponente compRepo;

	public List<Componente> getComponenti(String prodId) throws ProductNotFoundException {
		Prodotto prod = getProdotto(prodId);
		if(prod != null) {
			return prod.getComponenti();
		} else return null;
	}

	public Prodotto getProdotto(String prodId) throws ProductNotFoundException {
		Optional<Prodotto> result = repositoryProdotto.findById(prodId);
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
		return repositoryProdotto.findAll();
	}

	@Transactional
	public Prodotto salvaProdotto(@Valid Prodotto prodotto) throws DuplicatedProductException {
		if(repositoryProdotto.existsById(prodotto.getProdId()))
			throw new DuplicatedProductException(prodotto.getProdId());
		
		Prodotto _prodotto = new Prodotto();
		_prodotto.setNomeProdotto(prodotto.getNomeProdotto());
		_prodotto.setProdId(prodotto.getProdId());
		
		repositoryProdotto.save(_prodotto);
		
		//TODO: da rivedere
		
		return repositoryProdotto.findById(_prodotto.getProdId()).get();
	}

	public boolean esisteProdotto(String prodId) {
		return repositoryProdotto.existsById(prodId);
	}
}
