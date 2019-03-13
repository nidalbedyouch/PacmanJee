package fr.univangers.pacman.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
	private Long id;
	private String pseudo;
	private String email;
	private String pwd;
	private Date birthday;
	private Timestamp inscDate;
	

	public User() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String mdp) {
		this.pwd = mdp;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Timestamp getInscDate() {
		return inscDate;
	}

	public void setInscDate(Timestamp inscDate) {
		this.inscDate = inscDate;
	}
	
}
