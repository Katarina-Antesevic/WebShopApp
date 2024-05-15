package net.etfbl.webshop.service;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.beans.UserBean;
import net.etfbl.webshop.dao.UserDAO;


public class UserManager implements Serializable {
	


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2118947264650896055L;

	
	public ArrayList<UserBean> getAll(){
		return UserDAO.selectAll();
	}
	
	
	public boolean usersExists(String username) {
		boolean res = false;
		ArrayList<UserBean> kor=getAll();
		for(UserBean k:kor) {
			if(k.getUsername().equals(username)) {
				res=true;
				break;
			}
		}
		
		return res;
	}
	
	public UserBean getKorisnikById(int id) {
		UserBean k = new UserBean();
		for(UserBean kk : getAll()) {
			if(id == kk.getId()) {
				k=kk;
				break;
			}
		}
		
		
		return k;
	}
}
