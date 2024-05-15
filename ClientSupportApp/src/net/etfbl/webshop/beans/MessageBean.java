package net.etfbl.webshop.beans;

import java.io.Serializable;

public class MessageBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504073900396113605L;
	private int id;
	private String text;
	private String dateTime;
	private int isRead;
	private UserBean user;
	public MessageBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public MessageBean(int id, String text, String dateTime, int isRead, UserBean user) {
		super();
		this.id = id;
		this.text = text;
		this.dateTime = dateTime;
		this.isRead = isRead;
		this.user = user;
	}
	public MessageBean(String text, String dateTime, int isRead, UserBean user) {
		super();
		this.text = text;
		this.dateTime = dateTime;
		this.isRead = isRead;
		this.user = user;
	}

	
	
	
	
	
	

}
