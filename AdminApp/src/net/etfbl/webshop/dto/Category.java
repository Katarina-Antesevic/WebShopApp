package net.etfbl.webshop.dto;

import java.io.Serializable;

public class Category implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4213060171138622445L;
	private int id;
	private String name;
	private Integer parentCategoryId = null;
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
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Category(int id, String name, Integer parentCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.parentCategoryId = parentCategoryId;
	}
	public Category() {
		super();
	}
	public Category(String name, Integer parentCategoryId) {
		super();
		this.name = name;
		this.parentCategoryId = parentCategoryId;
	}
	
	
	
}
