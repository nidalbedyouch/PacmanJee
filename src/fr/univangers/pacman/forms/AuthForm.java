package fr.univangers.pacman.forms;


import javax.servlet.http.HttpServletRequest;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.univangers.pacman.DAO.UserDao;
import fr.univangers.pacman.beans.User;

public class AuthForm extends Form{
	private static final String CHAMP_UNAME = "uname";
	private static final String CHAMP_PWD = "psw";
	
	
	
	public AuthForm(UserDao user) {
		super(user);
	}
	
	public User connectUser(HttpServletRequest request) {
		String id = getValeurChamp(request, CHAMP_UNAME);
		String pwd = getValeurChamp(request, CHAMP_PWD);
		User user = userDao.find(id);
		if(user != null) {
			BCrypt.Result res = BCrypt.verifyer().verify(pwd.toCharArray(), user.getPwd());
			if(!res.verified) {
				setErreur(CHAMP_PWD, "mot de passe incorrect");
				user = null;
			}
		}else {
			setErreur(CHAMP_UNAME, "Identifiant indiqué n'existe pas");
		}
		if(erreurs.isEmpty())
			resultat = "Connexion réussie";
		else
			resultat = "Connexion échouée";
		
		return user;
	}

	public static String getChampUname() {
		return CHAMP_UNAME;
	}

	public static String getChampPwd() {
		return CHAMP_PWD;
	}

	
	
	
	
	
}
