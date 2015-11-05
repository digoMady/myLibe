package br.mylibe.model.negocio;

import java.io.Serializable;

/**
 * @author mady
 * @project myLibe
 */

public class UserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private BookBean book;
	

	public UserBean() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
