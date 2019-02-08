package it.unicam.ids.garbageCollectors.gestori;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.exception.BindingExcetion;
import it.unicam.ids.garbageCollectors.exception.ProposalException;
import it.unicam.ids.garbageCollectors.service.ServiceProposte;
import it.unicam.ids.garbageCollectors.utils.RichiestaProposta;

@RestController
@RequestMapping("/proposte")
public class GestoreProposte {
	
	@Autowired
	private ServiceProposte serviceProposte;
	
	@PostMapping
	public PropostaProdotto salvaPropostaProdotto(
			@Valid @RequestBody RichiestaProposta proposta, BindingResult result) throws BindingExcetion, ProposalException {
		
		if(result.hasErrors())
			throw new BindingExcetion();
		return serviceProposte.salvaPropostaProdotto(proposta);
	}
}
