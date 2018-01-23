package br.com.zup.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.dto.PoiDTO;
import br.com.zup.entity.Poi;
import br.com.zup.exceptions.ObjectNotFoundException;
import br.com.zup.repository.PoiRepository;

/**
 * Controlar serviços de {@link Poi}
 * 
 * @author paulo
 *
 */
@Service
public class PoiService {

	@Autowired
	private PoiRepository poiRepository;
	
	/**
	 * Trazer todos os poi cadastrados
	 * 
	 * @return 
	 */
	public List<Poi> findAll() {
		return this.poiRepository.findAll();
	}
	
	/**
	 * Lista poi pelo nome
	 * 
	 * @return 
	 */
	public List<Poi> findByName(final String name) {
		return this.poiRepository.findByName(name);
	}

	/**
	 * Método para buscar um poi pelo ID
	 * 
	 * @author paulo
	 * @throws ObjectNotFoundException
	 * @param id o identificador do poi
	 * @return o poi caso encontre.
	 */
	public Poi findById(final Integer id) {
		Poi poi = this.poiRepository.findOne(id);
		
		if (poi == null) {
			throw new ObjectNotFoundException(String.format("POI com o ID %s não foi encontrado.", id));
		}
		
		return poi;
	}
	
	/**
	 * Converter PoiDTO para entidade Poi
	 * 
	 * @param objDto
	 * @return
	 */
	public Poi fromDTO(PoiDTO objDto) {
		return new Poi(objDto.getId(), objDto.getName(), objDto.getCoordinatesX(), objDto.getCoordinatesY());
	}

	/**
	 * Remover um POI cadastrado
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		
		this.findById(id);		
		this.poiRepository.delete(id);
	}

	/**
	 * Método para inserir um novo POI 
	 * 
	 * @param obj
	 * @return
	 */
	public void insert(Poi obj) {
		obj.setId(null);
		obj = this.poiRepository.save(obj);
	}

	/**
	 * Método para retornar os poi pela distância / proximidade
	 * 
	 * @param coordinatesX
	 * @param coordinatesY
	 * @param maxDistante
	 * @return
	 */
	public List<Poi> findByProximity(final Integer coordinatesX, final Integer coordinatesY, final Integer maxDistante) {
		
		//Primeiro passo é buscar todos os pois da base de dados/
		List<Poi> listPois = this.findAll();
		List<Poi> result = new ArrayList<>(); // Lista de pois que será retornada de acordo com a busca
		
		if (listPois != null) {
			result = this.poisPerProximity(listPois, coordinatesX, coordinatesY, maxDistante);
		}
		
		return result;
	}
	
	/**
	 * Retorna a lista de pois pela proximidade
	 * 
	 * @param listPois
	 * @param coordinatesX
	 * @param coordinatesY
	 * @param maxDistante
	 * @return
	 */
	private List<Poi> poisPerProximity(List<Poi> listPois, Integer coordinatesX, Integer coordinatesY, Integer maxDistante) {
		List<Poi> result = new ArrayList<>();
		
		double coordX = coordinatesX.doubleValue();
		double coordY = coordinatesY.doubleValue();
		double maxDist = maxDistante;
		
		for (Poi p : listPois) {
			
			double distance = Math.hypot((p.getCoordinatesX().doubleValue() - coordX), 
					(p.getCoordinatesY().doubleValue() - coordY)); // obtendo a distância.
			
			if (distance <= maxDist) {
				result.add(p);
			}
		}
		
		return result;
	}
}
