package net.etfbl.webshop.beans;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.dao.UserDAO;
import net.etfbl.webshop.dto.User;


public class UserBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1798432202019318492L;

	public boolean insert(User korisnik) {
		return  UserDAO.insert(korisnik);
	}
	
	public ArrayList<User> getAll(){
		return UserDAO.selectAll();
	}
	
	public boolean delete(int id) {
		return UserDAO.delete(id);
	}
	
	public boolean update(User k) {
		return UserDAO.update(k);
	}
	
	public boolean usersExists(String username) {
		boolean res = false;
		ArrayList<User> kor=getAll();
		for(User k:kor) {
			if(k.getUsername().equals(username)) {
				res=true;
				break;
			}
		}
		
		return res;
	}
	
	public User getUserById(int id) {
		User k = new User();
		for(User kk : getAll()) {
			if(id == kk.getId()) {
				k=kk;
				break;
			}
		}
		
		
		return k;
	}
	
	public static void main(String args[]) {
		//UserBean k = new UserBean();
		User u = new User("a","a","a","a", "a","a","a","a");
		//UserDAO.insert(u);
		
		System.out.print(UserDAO.insert(u));
	}
	
}
