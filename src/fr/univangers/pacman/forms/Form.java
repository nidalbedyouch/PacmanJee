package fr.univangers.pacman.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.univangers.pacman.DAO.UserDao;

public abstract class Form {
	protected UserDao userDao;
	protected String resultat;
	protected Map<String,String> erreurs = new HashMap<String,String>();
	
	public Form(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Map<String,String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String,String> erreurs) {
		this.erreurs = erreurs;
	}
	
	protected void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}
	
	protected static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
}
