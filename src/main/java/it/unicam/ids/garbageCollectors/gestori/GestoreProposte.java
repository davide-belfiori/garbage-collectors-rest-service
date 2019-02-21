package it.unicam.ids.garbageCollectors.gestori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.exception.BindingException;
import it.unicam.ids.garbageCollectors.service.ServiceProposte;
import it.unicam.ids.garbageCollectors.utils.GruppoProposteProdotto;

@RestController
@RequestMapping("/api/proposte")
public class GestoreProposte {
	
	@Autowired
	private ServiceProposte serviceProposte;
	
	@PostMapping
	public PropostaProdotto salvaPropostaProdotto(@RequestParam(name = "nomeProdotto") String nomeProdotto,
												  @RequestParam(name = "prodId") String prodId,
												  @RequestParam(name = "nomeUtente") String nomeUtente) throws BindingException {
		
		if(nomeProdotto == null || prodId == null || nomeUtente == null) {
			throw new BindingException();
		}
		
		return serviceProposte.salvaPropostaProdotto(nomeProdotto, prodId, nomeUtente);

	}
	
	@DeleteMapping
	public ResponseEntity<?> scartaPropostaProdotto(@RequestParam(name = "prodId") String prodId,
											@RequestParam(name = "username") String username) throws BindingException {
		
		if(prodId == null || username == null) {
			throw new BindingException();
		}
		
		serviceProposte.scartaPropostaProdotto(prodId, username);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/isEnable/{nomeUtente}/{prodId}")
	public boolean propostaAbilitata(@PathVariable(name = "nomeUtente") String nomeUtente,
									 @PathVariable(name = "prodId") String prodId) {
		
		return !serviceProposte.esisteProposta(prodId, nomeUtente);
	}
	
	@GetMapping("/{prodId}")
	public List<PropostaProdotto> getProposteProdotto(@PathVariable(name = "prodId") String prodId) {
		return this.serviceProposte.getProposteProdotto(prodId);
	}
	
	@GetMapping("/group")
	public List<GruppoProposteProdotto> getGruppiProposteProdotto() {
		return serviceProposte.getGruppiProposteProdotto();
	}
	
	@GetMapping("/count")
	public long contaProposte(Authentication auth) {
		return serviceProposte.contaProposte();
	}
}
