package it.unicam.ids.garbageCollectors.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;
import it.unicam.ids.garbageCollectors.exception.ProposalException;
import it.unicam.ids.garbageCollectors.repository.RepositoryPropposteProdotto;
import it.unicam.ids.garbageCollectors.repository.RepositoryUtenti;
import it.unicam.ids.garbageCollectors.utils.RichiestaProposta;

@Service
public class ServiceProposte {
	
	@Autowired
	private RepositoryPropposteProdotto repositoryProposteProdotto;
	
	@Autowired
	private RepositoryUtenti repositoryUtenti;
	
	@Transactional
	public PropostaProdotto salvaPropostaProdotto(@Valid RichiestaProposta proposta) throws ProposalException {
		
		PropostaProdottoId id = new PropostaProdottoId(proposta.prodId,
				repositoryUtenti.findByUsername(proposta.nomeUtente));
		
		Optional<PropostaProdotto> result = repositoryProposteProdotto.findById(id);
		
		/* controllo che la proposta non sia stata già effettuata dallo stesso utente */
		if(result.isEmpty()) {
			PropostaProdotto _proposta = new PropostaProdotto(id);
			_proposta.setNomeProdotto(proposta.nomeProdotto);
			this.repositoryProposteProdotto.save(_proposta);
			return repositoryProposteProdotto.getOne(id);
		}
		throw new ProposalException(proposta.nomeUtente, proposta.prodId);
	}
}
