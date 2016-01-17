package br.com.ibiraweb.bean;



public class Login implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2534635806494307169L;
	private int 			id = 0;
	private String 			user = "";
	private String 			pass;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	

}
