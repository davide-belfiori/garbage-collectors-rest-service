package it.unicam.ids.garbageCollectors.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;
import it.unicam.ids.garbageCollectors.utils.GruppoProposteProdotto;

public interface RepositoryProposteProdotto extends JpaRepository<PropostaProdotto, PropostaProdottoId> {

	public List<PropostaProdotto> findByPropostaIdProdIdOrderByCreated(String prodId);
	
	@Query(value = "SELECT "+
				   		"prod_id AS prodId, COUNT(*) AS count " +
				   "FROM " +
				   		"proposta_prodotto p " +
				   "GROUP BY " +
				   		"p.prod_id " +
				   "ORDER BY " +
				   		"count DESC ", nativeQuery = true)
	public List<GruppoProposteProdotto> raggruppaProposteProdotto();
	
	@Query(value = "SELECT * FROM contatore_proposte WHERE true", nativeQuery = true)
	public long conta();
	
	@Modifying
	@Query(value = "UPDATE contatore_proposte SET \"count\" = \"count\" + 1", nativeQuery = true)
	public void incrementa();

	@Transactional
	public void deleteAllByPropostaIdProdId(String prodId);
}
