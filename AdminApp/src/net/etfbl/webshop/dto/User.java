package net.etfbl.webshop.dto;

import java.io.Serializable;

public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5464751075774244567L;
	private int id;
	private String fist_name;
	private String last_name;
	private String city;
	private String username;
	private String password;
	private String mail;
	private String avatar;
	private String pin;
	private boolean isActivated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFist_name() {
		return fist_name;
	}
	public void setFist_name(String fist_name) {
		this.fist_name = fist_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public boolean getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public User(int id, String fist_name, String last_name, String city, String username, String password,
			String mail, String avatar, String pin, boolean isActivated) {
		super();
		this.id = id;
		this.fist_name = fist_name;
		this.last_name = last_name;
		this.city = city;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.avatar = avatar;
		this.pin = pin;
		this.isActivated = isActivated;
	}
	public User(String fist_name, String last_name, String city, String username, String password, String mail,
			String avatar, String pin) {
		super();
		this.fist_name = fist_name;
		this.last_name = last_name;
		this.city = city;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.avatar = avatar;
		this.pin = pin;
		this.isActivated = true;
	
	}
	
	
	
	
	public User(int id, String fist_name, String last_name, String city, String username, String password,
			String mail) {
		super();
		this.id = id;
		this.fist_name = fist_name;
		this.last_name = last_name;
		this.city = city;
		this.username = username;
		this.password = password;
		this.mail = mail;
	}
	public User() {
		super();
	}
	
	

}
