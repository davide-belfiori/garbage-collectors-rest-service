package it.unicam.ids.garbageCollectors.gestori;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.exception.BindingExcetion;
import it.unicam.ids.garbageCollectors.service.ServiceProposte;

@RestController
@RequestMapping("/api/proposte")
public class GestoreProposte {
	
	@Autowired
	private ServiceProposte serviceProposte;
	
	@PostMapping
	public PropostaProdotto salvaPropostaProdotto(HttpServletRequest req) throws BindingExcetion {

		String nomeProdotto = req.getParameter("nomeProdotto");
		String prodId = req.getParameter("prodId");
		String nomeUtente = req.getParameter("nomeUtente");
		
		if(nomeProdotto != null && prodId != null && nomeUtente != null) {		
			return serviceProposte.salvaPropostaProdotto(nomeProdotto, prodId, nomeUtente);
		} throw new BindingExcetion();
	}
	
	@GetMapping("/isEnable/{nomeUtente}/{prodId}")
	public boolean propostaAbilitata(@PathVariable(name = "nomeUtente") String nomeUtente,
									 @PathVariable(name = "prodId") String prodId) {
		
		return !serviceProposte.esisteProposta(prodId, nomeUtente);
	}
	
	@GetMapping
	public List<PropostaProdotto> getProposteProdotto() {
		return serviceProposte.getListaProposteProdotto();
	}
	
	@GetMapping("/count")
	public long contaProposte() {
		return serviceProposte.contaProposte();
	}
	
}
