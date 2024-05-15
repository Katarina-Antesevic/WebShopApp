package net.etfbl.webshop.beans;

import java.io.Serializable;



public class AdminCustomerSupportBean  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3291146874547149478L;
	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private int admin;
	private boolean loggedIn = false;
	
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public AdminCustomerSupportBean() {
		super();
	}
	public AdminCustomerSupportBean(String first_name, String last_name, String username, String password, int admin) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	public AdminCustomerSupportBean(int id, String first_name, String last_name, String username, String password,
			int admin) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	
	
	
	

}
