package fr.univangers.pacman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.univangers.pacman.DAO.DAOFactory;
import fr.univangers.pacman.DAO.UserDao;
import fr.univangers.pacman.beans.User;
import fr.univangers.pacman.forms.AuthForm;

@WebServlet("/connexion")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String CONF_DAO_FACTORY = "daoFactory";
	private static final String VUE ="/WEB-INF/JSP/authentification.jsp";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	
	private UserDao userDao ;

	public void init() throws ServletException {
		/*récupération d'une instance de notre dao utilisateur */
		this.userDao = ( (DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY) ).getUserDao();
	}
	
    public Authentification() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AuthForm formConnexion = new AuthForm(userDao);
        User user = formConnexion.connectUser(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        
        session.setAttribute(ATT_SESSION_USER, user);
        response.setContentType("application/json");
        mapper.writeValue(response.getOutputStream(), formConnexion);
        
	}

}
