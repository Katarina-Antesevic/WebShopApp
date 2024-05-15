package net.etfbl.webshop.service;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.beans.AdminCustomerSupportBean;
import net.etfbl.webshop.dao.AdminCustomerSupportDAO;

public class AdminCustomerSupportManager implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 50536289086915478L;
	private AdminCustomerSupportBean user = new AdminCustomerSupportBean();
	private boolean isLoggedIn = false;
	
	public ArrayList<AdminCustomerSupportBean> getAll(){
		return AdminCustomerSupportDAO.selectAll();
	}
	
	
	
	public AdminCustomerSupportBean loginUser(String username, String password) {
		if(username==null || password == null) {
			return null;
		}
		for (AdminCustomerSupportBean u : getAll()) {
			if (u.getUsername().equals(username.trim()) && u.getPassword().equals(password.trim())) {
				if(u.getAdmin()==0)
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
		user=new AdminCustomerSupportBean();
		isLoggedIn=false;
		
	}

	public AdminCustomerSupportBean getKorisnikBean() {
		return user;
	}
	
	public static void main(String args[]) {
		AdminCustomerSupportManager km = new AdminCustomerSupportManager();
		km.loginUser("natasa", "natasa");
	}


}
