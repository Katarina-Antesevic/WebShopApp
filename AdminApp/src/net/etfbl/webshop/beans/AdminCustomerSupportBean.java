package net.etfbl.webshop.beans;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.dao.AdminCustomerSupportDAO;
import net.etfbl.webshop.dto.AdminCustomerSupport;;

public class AdminCustomerSupportBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6269719071148194359L;
	private AdminCustomerSupport user = new AdminCustomerSupport();
	
	
private boolean isLoggedIn = false;
	
	public ArrayList<AdminCustomerSupport> getAll(){
		return AdminCustomerSupportDAO.selectAll();
	}
	
	
	
	public AdminCustomerSupport loginUser(String username, String password) {
		if(username==null || password == null) {
			return null;
		}
		for (AdminCustomerSupport u : getAll()) {
			if (u.getUsername().equals(username.trim()) && u.getPassword().equals(password.trim())) {
				if(u.getAdmin()==1)
					return u;
			}
		}
		return null;
	}
	
	public boolean login(String username, String password) {
		if ((user = AdminCustomerSupportDAO.selectByUsernameAndPassword(username, password)) != null) {
			if(user.getAdmin()==0)
				isLoggedIn = true;
			return true;
		}
		return false;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	
	public void logOut() {
		user=new AdminCustomerSupport();
		isLoggedIn=false;
		
	}

	public AdminCustomerSupport getKorisnikBean() {
		return user;
	}
	
	

}
