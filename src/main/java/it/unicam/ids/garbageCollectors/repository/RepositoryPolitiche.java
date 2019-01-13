package it.unicam.ids.garbageCollectors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.ids.garbageCollectors.entity.PoliticaSmaltimento;
import it.unicam.ids.garbageCollectors.entity.PoliticaSmaltimentoId;

public interface RepositoryPolitiche extends JpaRepository<PoliticaSmaltimento, PoliticaSmaltimentoId> {
	
	/* effettua una select del tipo : 
	 * SELECT .... 
	 * FROM politica_smaltimento
	 * WHERE pol_prod_id == prodId && area_geografica_area_id == areaId
	 * 
	 * nella segnatura del metodo, la dicitura '...PolIdProdId...'
	 * fa riferimento al campo 'prodId' dell'attributo 'polId' (di tipo 'PoliticaSmaltimentoId')
	 * della classe 'PoliticaSmaltimento'
	 * 
	 * La stessa cosa accade per la dicitura '...PolIdAreaId...'
	 * 
	 * La dicitura '...And...' serve per concatenare i due filtri
	 */
	public List<PoliticaSmaltimento> findByPolIdProdIdAndPolIdAreaId(String prodId, int areaId);
}
