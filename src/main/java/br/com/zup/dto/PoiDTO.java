package br.com.zup.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.zup.entity.Poi;

public class PoiDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	
	@Min(1)
	private Integer coordinatesX;
	
	@Min(1)
	private Integer coordinatesY;
	
	public PoiDTO() {
	
	}
	
	public PoiDTO(Poi poi) {
		super();
		this.id = poi.getId();
		this.name = poi.getName();
		this.coordinatesX = poi.getCoordinatesX();
		this.coordinatesY = poi.getCoordinatesY();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the coordinatesX
	 */
	public Integer getCoordinatesX() {
		return coordinatesX;
	}

	/**
	 * @param coordinatesX the coordinatesX to set
	 */
	public void setCoordinatesX(Integer coordinatesX) {
		this.coordinatesX = coordinatesX;
	}

	/**
	 * @return the coordinatesY
	 */
	public Integer getCoordinatesY() {
		return coordinatesY;
	}

	/**
	 * @param coordinatesY the coordinatesY to set
	 */
	public void setCoordinatesY(Integer coordinatesY) {
		this.coordinatesY = coordinatesY;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoiDTO [id=" + id + ", name=" + name + ", coordinatesX=" + coordinatesX + ", coordinatesY="
				+ coordinatesY + "]";
	}
	
}
