package br.com.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.zup.dto.PoiDTO;
import br.com.zup.entity.Poi;
import br.com.zup.exceptions.DataIntegrityException;
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
}
