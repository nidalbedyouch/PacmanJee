package fr.univangers.pacman.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.univangers.pacman.DAO.DAOFactory;

@WebListener 
public class InitDaoFatory implements ServletContextListener {

	private static final String ATT_DAO_FATORY = "daoFactory";
	private DAOFactory daoFactory;
	
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext(); //récupération du ServletContext lors du chargement de l'application 
		this.daoFactory  = DAOFactory.getInstance();	
		/* Enregistrement dans un attribut ayant pour portée toute l'application */
		servletContext.setAttribute(ATT_DAO_FATORY, this.daoFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		 /* Rien à réaliser lors de la fermeture de l'application... */
	}

}
