package net.etfbl.webshop.dto;

import java.io.Serializable;

public class Attribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -548204718943394749L;
	private int id;
	private String name;
	private Category category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribute other = (Attribute) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Attribute(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	public Attribute() {
		super();
	}
	public Attribute(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}
	
	
	

}
