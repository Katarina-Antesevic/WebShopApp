package net.etfbl.webshop.service;

import java.io.Serializable;
import java.util.ArrayList;

import net.etfbl.webshop.beans.MessageBean;
import net.etfbl.webshop.dao.MessageDAO;



public class MessageManager implements Serializable {


	
	
	/**
	 * 
	 */
	
	private int intVrij;
	private String content;
	
	
	
	public int getIntVrij() {
		return intVrij;
	}


	public void setIntVrij(int intVrij) {
		this.intVrij = intVrij;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	private static final long serialVersionUID = 8888503807145815017L;
	
	public boolean update(MessageBean pitanje) {
		return MessageDAO.update(pitanje);
	}
	
	public ArrayList<MessageBean> getAll(){
		return MessageDAO.selectAll();
	}
	
	public ArrayList<MessageBean> getByContent(String content) {
		ArrayList<MessageBean> res=new ArrayList<>();
		for(MessageBean p:getAll()) {
			if(p.getText().toUpperCase().contains(content.toUpperCase())) {
				res.add(p);
			}
		}
		return res;
	}
	
	public ArrayList<MessageBean> getNotRead(){
		return MessageDAO.selectNotRead();
	}
	
	
	public ArrayList<MessageBean> getMessagesByUserId(int id){
		return MessageDAO.selectBySpecificUserId(id);
	}
	
	public ArrayList<MessageBean> odgovarajucaFunkcija(int intVrij, String content) {
		ArrayList<MessageBean> res = new ArrayList<>();
		if(intVrij==0) {
			 res= getNotRead();
		}
		else {
			 res=getByContent(content);
		}
		
		return res;
	}
	
	public MessageBean getMessageById(int id) {
		MessageBean k = new MessageBean();
		for(MessageBean kk : getAll()) {
			if(id == kk.getId()) {
				k=kk;
				break;
			}
		}
		
		
		return k;
	}
}

	
