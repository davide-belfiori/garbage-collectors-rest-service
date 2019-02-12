package it.unicam.ids.garbageCollectors.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;
import it.unicam.ids.garbageCollectors.repository.RepositoryProposteProdotto;
import it.unicam.ids.garbageCollectors.repository.RepositoryUtenti;

@Service
public class ServiceProposte {
	
	@Autowired
	private RepositoryProposteProdotto repositoryProposteProdotto;
	
	@Autowired
	private RepositoryUtenti repositoryUtenti;
	
	@Transactional
	public PropostaProdotto salvaPropostaProdotto(String nomeProdotto, String prodId, String nomeUtente) {
		
		PropostaProdottoId id = new PropostaProdottoId(prodId,
				repositoryUtenti.findByUsername(nomeUtente));
		
		PropostaProdotto _proposta = new PropostaProdotto(id);
		_proposta.setNomeProdotto(nomeProdotto);
		this.repositoryProposteProdotto.save(_proposta);
		this.incementaProposte();
		return repositoryProposteProdotto.getOne(id);
	}

	public boolean esisteProposta(String prodId, String nomeUtente) {
		
		PropostaProdottoId id = new PropostaProdottoId(prodId,
				repositoryUtenti.findByUsername(nomeUtente));
		
		return repositoryProposteProdotto.existsById(id);
	}

	public List<PropostaProdotto> getListaProposteProdotto() {
		return repositoryProposteProdotto.findAllByOrderByCreated();
	}

	public long contaProposte() {
		return repositoryProposteProdotto.conta();
	}
	
	private void incementaProposte() {
		repositoryProposteProdotto.incrementa();
	}
}
