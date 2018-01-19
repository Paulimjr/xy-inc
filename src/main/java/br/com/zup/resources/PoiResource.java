package br.com.zup.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.dto.PoiDTO;
import br.com.zup.entity.Poi;
import br.com.zup.services.PoiService;

/**
 * Controlar as requisções de {@link Poi}
 * 
 * @author paulo
 *
 */
@RestController
@RequestMapping(value = "/pois")
public class PoiResource {
	
	@Autowired
	private PoiService poiService;
	
	/**
	 * API para inserir um poi
	 * 
	 * @param objDto
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PoiDTO objDto) {
		Poi obj = this.poiService.fromDTO(objDto);
		this.poiService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/**
	 * API para trazer todos os pois
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PoiDTO>> findAll() {
		List<Poi> list = this.poiService.findAll();
		List<PoiDTO> listDto = list.stream().map(obj -> new PoiDTO(obj)).collect(Collectors.toList());  
		
		return ResponseEntity.ok().body(listDto);
	}
	
	/**
	 * API para consultar um poi pelo identificador
	 * 
	 * @author paulo
	 * @param id o identificador do poi
	 * @return o poi
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable final Integer id) {
		Poi cli = this.poiService.findById(id);
		return  ResponseEntity.ok().body(cli);
	}
	
	/**
	 * API para remover um poi
	 * 
	 * @param id o identificador do poi
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.poiService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * API para consultar um poi pelo nome
	 * 
	 * @author paulo
	 * @param name o nome do poi
	 * @return o poi
	 */
	@RequestMapping(value = "/findByName", method=RequestMethod.GET)
	public ResponseEntity<?> findByName(@RequestParam(value="name", defaultValue="") String name) {
		List<Poi> pois = this.poiService.findByName(name);
		return  ResponseEntity.ok().body(pois);
	}
}
