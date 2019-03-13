package fr.univangers.pacman.forms;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.univangers.pacman.DAO.DAOException;
import fr.univangers.pacman.DAO.DAOUTILITY;
import fr.univangers.pacman.DAO.UserDao;
import fr.univangers.pacman.beans.User;

public class RegisterForm extends Form{
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PSEUDO = "uname";
	private static final String CHAMP_BDAY = "bday";
	private static final String CHAMP_PWD = "pwd"; 
	private static final String CHAMP_CONF =  "confirmation";
	
	
	public RegisterForm(UserDao userDao) {
		super(userDao);
	}
	
	public User registerUser(HttpServletRequest request) {
		User user = new User();
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String pseudo = getValeurChamp(request, CHAMP_PSEUDO);
		Date bday = new Date(DAOUTILITY.parseDate(getValeurChamp(request, CHAMP_BDAY)).getTime());
		System.out.println(bday);
		String pwd = getValeurChamp(request, CHAMP_PWD);
	    String confiramtion = getValeurChamp(request, CHAMP_CONF);
		 
	    try {
	    	traiterEmail(email, user);
	    	traiterPseudo(pseudo, user);
	    	traiterPwd(pwd, confiramtion, user);
	    	traiterBday(bday,user);

			if(erreurs.isEmpty()) {
				 userDao.insert(user);
				 resultat = "Succés de l'inscription.";
			}	
			else 
				resultat = "Échec de l'inscription.";
	    	
	    }catch(DAOException e) {
	    	resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
	        e.printStackTrace();
	    }	
	    System.out.println(resultat);
	    for(String e : erreurs.keySet()) {
	    	System.out.println(e+"   "+erreurs.get(e));
	    }
		return user;
	}
	
	public void CheckValidity(HttpServletRequest request) {
		User user = new User();
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String pseudo = getValeurChamp(request, CHAMP_PSEUDO);
		Date bday = new Date(DAOUTILITY.parseDate(getValeurChamp(request, CHAMP_BDAY)).getTime());
		System.out.println(bday);
		String pwd = getValeurChamp(request, CHAMP_PWD);
	    String confiramtion = getValeurChamp(request, CHAMP_CONF);
	    
	    traiterEmail(email, user);
    	traiterPseudo(pseudo, user);
    	traiterPwd(pwd, confiramtion, user);
    	traiterBday(bday,user);

		if(erreurs.isEmpty()) {
			 userDao.insert(user);
			 resultat = "Succés de l'inscription.";
		}	
		else 
			resultat = "Échec de l'inscription.";
	}

	private void traiterBday(Date bday, User user) {
		try {
			validBday(bday);
		}catch(FormException e) {
			setErreur(CHAMP_BDAY, e.getMessage());
		}
		user.setBirthday(bday);
	}
	private void traiterPseudo(String pseudo,User user) {
		try {
			validPseudo(pseudo);
		}catch(FormException e) {
			setErreur(CHAMP_PSEUDO,e.getMessage());
		}
		user.setPseudo(pseudo);
	}
	
	public void traiterEmail(String email,User user) {
		try {
			validEmail( email);
		}catch(FormException e ) {
			setErreur(CHAMP_EMAIL,e.getMessage());
			setErreur(CHAMP_CONF,null);
		}
		
		user.setEmail(email);
	}
	
	public void traiterPwd(String pwd,String confirmation,User user) {
		try {
			validPwd(pwd,confirmation);
		}catch(FormException e) {
			setErreur(CHAMP_PWD,e.getMessage());
			setErreur(CHAMP_CONF,null);
		}
		if(pwd!=null) {
			String cryptPass = BCrypt.withDefaults().hashToString(12, pwd.toCharArray());	
			user.setPwd(cryptPass);
		}
	}
	
	private void validBday(Date bday) throws FormException {
		if(bday == null ) {
			throw new FormException("Birthday vide");
		}
		
	}
	
	private void validPseudo(String pseudo) throws FormException {
		 if ( pseudo != null && pseudo.length() < 3 ) {
			 throw new FormException( "Pseudo doit contenir au moins 3 caractères." );
		}
		if(userDao.find(pseudo) != null)
			 throw new FormException( "Pseudo déjà utilisé." );
		
	}

	private void validPwd(String pwd,String confirmation) throws FormException {
		 if ( pwd != null && confirmation != null ) {
		        if ( !pwd.equals( confirmation ) ) {
		            throw new FormException( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
		        } else if(!pwd.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
					throw new FormException("Les mots de passe doit être composé d'une miniscule, "
							+ "une majuscule et un chiffre.");
		        }
		} else {
		      throw new FormException( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	
	private void validEmail(String email) throws FormException {
		 if ( email != null ) {
		        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
		            throw new FormException( "Merci de saisir une adresse mail valide." );
		        } else {
		        	//check if address already exist
		        }
		} else {
		        throw new FormException( "Merci de saisir une adresse mail." );
		}
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
