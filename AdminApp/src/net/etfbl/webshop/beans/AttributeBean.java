package net.etfbl.webshop.beans;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.dao.AttributeDAO;
import net.etfbl.webshop.dto.Attribute;
import net.etfbl.webshop.dto.Category;



public class AttributeBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3031416240632853670L;

	public boolean insert(Attribute a) {
		return AttributeDAO.insert(a);
	}
	
	public ArrayList<Attribute> getAll(){
		return AttributeDAO.selectAll();
	}
	
	public ArrayList<Attribute> getAtributesBySpecificCategoryId(int id){
		return AttributeDAO.selectBySpecificCategoryId(id);
	}
	
	public boolean update(Attribute kategorija) {
		return AttributeDAO.update(kategorija);
	}
	
	public boolean delete(int id) {
		return AttributeDAO.delete(id);
	}
	
	public Attribute getAtributById(int id) {
		Attribute k = new Attribute();
		for(Attribute kk: getAll()) {
			if(kk.getId()==id) {
				k=kk;
				break;
			}
		}
		return k;
	}
	
	
	public Category getCategoryById(Attribute a) {
		Category c = new Category();
		CategoryBean cb = new CategoryBean();
		for(Category cat: cb.getAll()) {
			if(cat.getId() == a.getCategory().getId()) {
				c=cat;
				break;
			}
		}
		
		
		return c;
	}

}
