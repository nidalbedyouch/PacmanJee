package fr.univangers.pacman.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.pacman.DAO.DAOFactory;
import fr.univangers.pacman.DAO.PartieDAO;
import fr.univangers.pacman.beans.Partie;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONF_DAO_FACTORY = "daoFactory";
	private static final String VUE ="/index.jsp";
	private static final String ATT_TOP_GAMES = "topGames";
	private static final String ATT_ACTION = "action";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";


	
	private PartieDAO partieDao ;

	public void init() throws ServletException {
		/*récupération d'une instance de notre dao partie */
		this.partieDao = ( (DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY) ).getPartieDAO();
		
	}
    
    public Index() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Partie> games = partieDao.getTop4Games();
        request.setAttribute(ATT_TOP_GAMES, games);
        String action = request.getParameter(ATT_ACTION);
		if(action != null && action.equals("logout")) {
			HttpSession session = request.getSession();
			try {
				session.invalidate();
				response.sendRedirect("index");
			}catch(Exception e) {
				
			}
			
		}else
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);        
	}

}
