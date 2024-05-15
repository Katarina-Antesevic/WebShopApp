package net.etfbl.webshop.beans;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.dao.CategoryDAO;
import net.etfbl.webshop.dto.Category;

public class CategoryBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676515947889267832L;

	public boolean insert(Category kategorija) {
		return CategoryDAO.insert(kategorija);
	}
	

	
	public ArrayList<Category> getAll(){
		ArrayList<Category> cats=new ArrayList<>();
		for(Category c: CategoryDAO.selectAll()) {
			if(c.getParentCategoryId()==0) {
				cats.add(c);
			}
		}
		return cats;
	}
	
	public ArrayList<Category> getAllSubcategories() {
		ArrayList<Category> cats=new ArrayList<>();
		for(Category c: CategoryDAO.selectAll()) {
			if(c.getParentCategoryId()>0) {
				cats.add(c);
			}
		}
		return cats;
	}
	
	public ArrayList<Category> getSubcategoriesByCategoryId(Integer id){
		ArrayList<Category> subs = new ArrayList<>();
		for(Category c: getAllSubcategories()) {
			
				if(c.getParentCategoryId() == id)
				subs.add(c);
			
		}
		return subs;
	}
	
	public boolean update(Category kategorija) {
		return CategoryDAO.update(kategorija);
	}
	
	public boolean delete(int id) {
		return CategoryDAO.delete(id);
	}
	
	public Category getCategoryById(int id) {
		Category k = new Category();
		for(Category kk: getAll()) {
			if(kk.getId()==id) {
				k=kk;
				break;
			}
		}
		return k;
	}
	
	public Category getSubCategoryById(int id) {
		Category k = new Category();
		for(Category kk: getAllSubcategories()) {
			if(kk.getId()==id) {
				k=kk;
				break;
			}
		}
		return k;
	}
	
	
	
	
	public static void main(String args[]) {
		/*for(Category c: CategoryDAO.selectAll()) {
			if(c.getParentCategoryId()>0)
			System.out.println(c.getName()+" "+c.getParentCategoryId());
		}*/
		CategoryBean cb= new CategoryBean();
		Category c  = cb.getCategoryById(1);
		System.out.println(c.getName());
		/*
		for(Category c: cb.getSubcategoriesByCategoryId(1)) {
			System.out.println(c.getName()+" "+c.getParentCategoryId());
		}*/
	}
	
	

}
