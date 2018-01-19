package br.com.zup.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidade de POI
 * 
 * @author paulo
 *
 */
@Entity
public class Poi implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "coordinatesX")
	private Integer coordinatesX;
	
	@Column(name = "coordinatesY")
	private Integer coordinatesY;

	
	public Poi() {
		super();
	}

	public Poi(Integer id, String name, Integer coordinatesX, Integer coordinatesY) {
		super();
		this.id = id;
		this.name = name;
		this.coordinatesX = coordinatesX;
		this.coordinatesY = coordinatesY;
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
		return "Poi [id=" + id + ", name=" + name + ", coordinatesX=" + coordinatesX + ", coordinatesY=" + coordinatesY
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
