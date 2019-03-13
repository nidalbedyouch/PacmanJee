package fr.univangers.pacman.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


public class DAOFactory {
	private static final String Fichier_Properties="fr/univangers/pacman/DAO/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	
	private DataSource datasource;
	
	DAOFactory(DataSource datasource){
		this.setDatasource(datasource);
	}
	
	public static DAOFactory getInstance() throws DAOException{
		Properties properties = new Properties();
		String url,driver;
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(Fichier_Properties);
		
		if(fichierProperties == null) {
			throw new DAOConfigurationException("le fichier properties "+Fichier_Properties+" est introuvable");
		}
		
		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
		}catch(IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier properties "+Fichier_Properties,e);
		}
		
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			throw new DAOConfigurationException("Le driver est introuvable ",e);
		}
		
		 PoolProperties p = new PoolProperties();
	     p.setUrl(url);
	     p.setDriverClassName(driver);
	     DataSource datasource = new DataSource();
	     datasource.setPoolProperties(p);
		
		return new DAOFactory(datasource);
	}
	
	 Connection getConnection() throws SQLException {
	        return datasource.getConnection();
	 }
	
	public UserDao getUserDao() {
		return new UserDaoImpl(this);
	}
	
	public PartieDAO getPartieDAO() {
		return new PartieDaoImpl(this);
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	
}
