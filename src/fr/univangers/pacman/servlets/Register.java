package fr.univangers.pacman.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.univangers.pacman.DAO.DAOFactory;
import fr.univangers.pacman.DAO.PartieDAO;
import fr.univangers.pacman.DAO.UserDao;
import fr.univangers.pacman.beans.Partie;
import fr.univangers.pacman.beans.User;
import fr.univangers.pacman.forms.RegisterForm;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String CONF_DAO_FACTORY = "daoFactory";
	private static final String VUE ="/WEB-INF/JSP/inscription.jsp";
	private static String ATT_USER = "user";
	private static String ATT_FORM = "form";
	private static final String ATT_TOP_GAMES = "topGames";
	private static final String ATT_ACTION = "action";

	
	private UserDao userDao ;
	private PartieDAO partieDao ;

    
	public void init() throws ServletException {
		/*récupération d'une instance de notre dao utilisateur */
		this.userDao = ( (DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY) ).getUserDao();
		this.partieDao = ( (DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY) ).getPartieDAO();
	}
	
    public Register() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Partie> games = partieDao.getTop4Games();
        request.setAttribute(ATT_TOP_GAMES, games);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* Préparation de l'objet formulaire */
        RegisterForm form = new RegisterForm( userDao );
        String action = request.getParameter(ATT_ACTION);
		if(action != null && action.equals("validate")) {
			System.out.println("Register validate called");
			form.CheckValidity(request);
			ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        response.setContentType("application/json");
	        mapper.writeValue(response.getOutputStream(), form);
		}else {
	        /* Traitement de la requête et récupération du bean en résultant */
	        User user = form.registerUser( request );
	
	        /* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute( ATT_FORM, form );
	        request.setAttribute( ATT_USER, user );
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
        
	}

}
