package org.dteam.dao;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int POSTGRES = 2;
	
	public abstract UserDAO getUserDAO();
	public abstract ReadingDAO getReadingDAO();
	public abstract A1cDAO getA1cDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory){
		switch(whichFactory){
		case MYSQL:
			return new MySQLDAOFactory();
		case POSTGRES:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	

}
