package br.com.zup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.entity.Poi;

/**
 * The repository for the {@link Poi}
 * 
 * @author paulo
 *
 */
@Repository
public interface PoiRepository extends JpaRepository<Poi, Integer> {

	/**
	 * Retornar os pois pelo nome
	 * 
	 * @param name
	 * @return
	 */
	List<Poi> findByName(final String name);
}
